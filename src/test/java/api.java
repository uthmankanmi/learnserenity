import com.jayway.restassured.RestAssured;

import com.jayway.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 * Created by casper on 08/03/16.
 */
public class api {
    String emails[] = {"aab57943@iaoss.com",
            "aeb70451@iaoss.com",
            "aem07017@iaoss.com",
            "ake47695@iaoss.com",
            "anv88210@iaoss.com",
            "auj02697@iaoss.com",
            "aur79877@iaoss.com",
            "awd44747@iaoss.com",
            "axz65746@iaoss.com",
            "bao89268@iaoss.com",
            "beg56119@iaoss.com",
            "bir90478@iaoss.com",
            "blu79067@iaoss.com",
            "bmk76104@iaoss.com",
            "bth55048@iaoss.com",
            "ccc91100@iaoss.com",
            "ceu27235@iaoss.com",
            "cfh74354@iaoss.com",
            "ckl52728@iaoss.com",
            "cmm30803@iaoss.com",
            "crh32908@iaoss.com",
            "cuu83441@iaoss.com",
            "cya03068@iaoss.com",
            "czi25347@iaoss.com",
            "dbh76604@iaoss.com",
            "dca50560@iaoss.com",
            "dje72387@iaoss.com",
            "dnq29732@iaoss.com",
            "dou59123@iaoss.com",
            "dpb15263@iaoss.com",
            "dpq30315@iaoss.com",
            "drb46874@iaoss.com",
            "dsc41541@iaoss.com",
            "dss49825@iaoss.com",
            "dty37257@iaoss.com",
            "dxa54840@iaoss.com",
            "ecn63823@iaoss.com",
            "eez14003@iaoss.com",
            "eez48077@iaoss.com",
            "ena30979@iaoss.com",
            "eng88768@iaoss.com",
            "eye24428@iaoss.com",
            "fhq54413@iaoss.com",
            "fjg38601@iaoss.com",
            "fkl64155@iaoss.com",
            "fny32372@iaoss.com",
            "frs11455@iaoss.com",
            "fry41386@iaoss.com",
            "fts97605@iaoss.com",
            "gdm20936@iaoss.com",
            "glu51459@iaoss.com",
            "gpi84971@iaoss.com",
            "gro99640@iaoss.com",
            "grw53881@iaoss.com",
            "gvq12464@iaoss.com",
            "hdm12666@iaoss.com",
            "hic85560@iaoss.com",
            "hmk21453@iaoss.com",
            "hmu35093@iaoss.com",
            "hsa72880@iaoss.com",
            "hvn96772@iaoss.com",
            "hwz56535@iaoss.com",
            "hyj32974@iaoss.com",
            "ias84477@iaoss.com",
            "ioo74597@iaoss.com",
            "iqh99674@iaoss.com",
            "iqs07437@iaoss.com",
            "isn22069@iaoss.com",
            "ivj96351@iaoss.com",
            "ixi14707@iaoss.com",
            "ixu63425@iaoss.com",
            "iyi49129@iaoss.com",
            "iyn51340@iaoss.com",
            "jad22001@iaoss.com",
            "jhi38693@iaoss.com",
            "jkn75630@iaoss.com",
            "jnm39723@iaoss.com",
            "jop02077@iaoss.com",
            "jpr83185@iaoss.com",
            "jrg11262@iaoss.com",
            "kaz30804@iaoss.com",
            "kho69673@iaoss.com",
            "kiu34202@iaoss.com",
            "kkk02147@iaoss.com",
            "ksp94812@iaoss.com",
            "lac08873@iaoss.com",
            "lbd89291@iaoss.com",
            "lkv17643@iaoss.com",
            "log05697@iaoss.com",
            "lsf28571@iaoss.com",
            "lxd36417@iaoss.com",
            "lyr88367@iaoss.com",
            "lzb51782@iaoss.com",
            "mam77721@iaoss.com",
            "mcu52611@iaoss.com",
            "mgs97399@iaoss.com",
            "mot51265@iaoss.com",
            "mra00852@iaoss.com",
            "mra85921@iaoss.com",
            "mwz94814@iaoss.com",
            "mys23953@iaoss.com",
            "mzn65633@iaoss.com",
            "mzp18722@iaoss.com",
            "nak16149@iaoss.com",
            "nap43310@iaoss.com",
            "ngs70325@iaoss.com",
            "npf75527@iaoss.com",
            "ntr80760@iaoss.com",
            "nyx73326@iaoss.com",
            "ofe74020@iaoss.com",
            "ogx96703@iaoss.com",
            "ojo43748@iaoss.com",
            "opa70959@iaoss.com",
            "ovb02897@iaoss.com",
            "oyn71583@iaoss.com",
            "pex04780@iaoss.com",
            "pig35793@iaoss.com",
            "ppl61979@iaoss.com",
            "prg13160@iaoss.com",
            "pvg73729@iaoss.com",
            "qaj91985@iaoss.com",
            "qgt92957@iaoss.com",
            "qhf52080@iaoss.com",
            "qjq85404@iaoss.com",
            "qnc64596@iaoss.com",
            "rfq92395@iaoss.com",
            "rfs67530@iaoss.com",
            "rou07455@iaoss.com",
            "rpe65915@iaoss.com",
            "rux89290@iaoss.com",
            "rvo00136@iaoss.com",
            "sff84792@iaoss.com",
            "sio24537@iaoss.com",
            "sjx93898@iaoss.com",
            "slr15928@iaoss.com",
            "ssg69664@iaoss.com",
            "swp12597@iaoss.com",
            "szs53085@iaoss.com",
            "tao19295@iaoss.com",
            "tcn45987@iaoss.com",
            "tek97195@iaoss.com",
            "tmo64461@iaoss.com",
            "tnt40331@iaoss.com",
            "tqk18782@iaoss.com",
            "tqu62151@iaoss.com",
            "tsd29308@iaoss.com",
            "tzo54965@iaoss.com",
            "uap26624@iaoss.com",
            "udp96967@iaoss.com",
            "ugv93939@iaoss.com",
            "upx95379@iaoss.com",
            "ute20784@iaoss.com",
            "uxp05505@iaoss.com",
            "vdh46927@iaoss.com",
            "vjc61811@iaoss.com",
            "vlk04689@iaoss.com",
            "vub61103@iaoss.com",
            "vwj75666@iaoss.com",
            "vym00894@iaoss.com",
            "wcj56523@iaoss.com",
            "wiw32260@iaoss.com",
            "wjb29280@iaoss.com",
            "wmj35225@iaoss.com",
            "wpt76441@iaoss.com",
            "wux24358@iaoss.com",
            "xbg53177@iaoss.com",
            "xgf76997@iaoss.com",
            "xif07933@iaoss.com",
            "xll62016@iaoss.com",
            "xud81016@iaoss.com",
            "xuz77025@iaoss.com",
            "xyh29588@iaoss.com",
            "xyj04008@iaoss.com",
            "ybk23995@iaoss.com",
            "ygb01077@iaoss.com",
            "yhz07695@iaoss.com",
            "yig13614@iaoss.com",
            "ymq35957@iaoss.com",
            "yqj28795@iaoss.com",
            "yrs61763@iaoss.com",
            "yvj67011@iaoss.com",
            "zek33489@iaoss.com",
            "zgy86180@iaoss.com",
            "zjh51890@iaoss.com",
            "zji69360@iaoss.com",
            "zjt96896@iaoss.com",
            "zlg76262@iaoss.com",
            "zlr13503@iaoss.com"};

    // public static  String email = "/users/?email=qnc64596@iaoss.com";

    public String getIDbyEmail(String email) {
        RestAssured.baseURI = "http://springer-user-service.live.cf.private.springer.com";
        Response response = given().
                header("X-API-Key", "casper123!").
                contentType("application/json").
                when().
                get("/users/?email=" + email).prettyPeek();
        return response.then().extract().path("id");
    }


    public List<String> getBPID(String id) {
        RestAssured.baseURI = "http://user-business-partners-service.live.cf.private.springer.com";
        Response response = given().
                header("X-API-Key", "casper123!").
                contentType("application/json").
                when().
                get("/users/" + id + "/business-partners").prettyPeek();
        try {
            return response.then().extract().path("businessPartners.id");
        } catch (IllegalArgumentException e) {
        }
        return null;
    }


    @Test
    public void testing() {
        List<String> bpid = null;        //get emails and loop them in to get all ids
        for (String email : emails) {
            String userId = getIDbyEmail(email);

            try {getBPID(userId).get(0); {
                    bpid.add(getBPID(userId).get(0));//create a list of ids}
                }
            } catch(NullPointerException e ){

            }

            System.out.print(bpid);
        }
    }
}


