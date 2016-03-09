
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.jcraft.jsch.*;
import java.util.logging.Level;

public class MysqlManager {

    // Logger
    private final static Logger LOGGER =
            Logger.getLogger(MysqlManager.class.getName());
    public static final String USER = "casper";
    public static final String SSH_PASSWORD = "Gut3nb3rg1398";

    final String DATABASE_USERNAME ="springer-ro";
    final String DATABASE_PASSWORD ="Regnirps";
    final String DATABASE = "springer";

    public static void main(String args[]) {
        MysqlManager mng = new MysqlManager ();
        mng.connect();
    }

    public void connect() {

        //
        int assigned_port;
        final int LOCAL_PORT=3306;

        // Remote host and port
        final int REMOTE_PORT=3306;
        final String REMOTE_HOST="sl-live-mysql-02.springer-sbm.com";

        try {
            JSch jsch = new JSch();

            // Create SSH session.  Port 22 is your SSH port which
            // is open in your firewall setup.
            Session session = jsch.getSession(USER, REMOTE_HOST, 22);
            session.setPassword(SSH_PASSWORD);

            // Additional SSH options.  See your ssh_config manual for
            // more options.  Set options according to your requirements.
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("Compression", "yes");
            config.put("ConnectionAttempts","2");

            session.setConfig(config);

            // Connect
            session.connect();

            // Create the tunnel through port forwarding.
            // This is basically instructing jsch session to send
            // data received from local_port in the local machine to
            // REMOTE_PORT of the REMOTE_HOST
            // assigned_port is the port assigned by jsch for use,
            // it may not always be the same as
            // local_port.

            assigned_port = session.setPortForwardingL(LOCAL_PORT,
                    REMOTE_HOST, REMOTE_PORT);

        } catch (JSchException e) {
            LOGGER.log(Level.SEVERE, e.getMessage()); return;
        }

        if (assigned_port == 0) {
            LOGGER.log(Level.SEVERE, "Port forwarding failed !");
            return;
        }

        // Database access credintials.  Make sure this user has
        // "connect" access to this DATABASE;

        // these may be initialized somewhere else in your code.


        // Build the  DATABASE connection URL.
        StringBuilder url =
                new StringBuilder("jdbc:mysql://localhost:");

        // use assigned_port to establish DATABASE connection
        url.append(assigned_port).append ("/").append(DATABASE).append ("?user=").
                append(DATABASE_USERNAME).append ("&password=").
                append (DATABASE_PASSWORD);

        try {
            Class.forName(
                    "com.mysql.jdbc.Driver").newInstance();
            java.sql.Connection connection =
                    java.sql.DriverManager.getConnection(url.toString());


            Statement st= connection.createStatement();
            String sql = "SELECT * FROM springer.BusinessPartner limit 1";
            ResultSet rs = st.executeQuery(sql);

            List<List<String>> results = new ArrayList<List<String>>();
            while (rs.next()) {
                ResultSetMetaData meta = rs.getMetaData();
                List<String> lines = new ArrayList<String>();

                for (int col = 1; col < meta.getColumnCount() + 1; col++) {
                    lines.add(rs.getString(col));
                }
                results.add(lines);
            }



        } catch (ClassNotFoundException |
                IllegalAccessException |
                InstantiationException |
                java.sql.SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

    }
}