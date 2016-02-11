package StepsDefinition.Login;

import com.ortsevlised.Springer.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;


/**
 * Created by Jorge on 16/12/2015.
 */
public class LoginDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Given("^I visit Identity client mock page$")
    public void i_visit_Identity_client_mock_page() {
        loginSteps.navigateToIdentityClientMockPage();
    }

    @Given("^I click on link Log in with id\\.nature\\.com requesting email profile scope$")
    public void i_click_on_link_Log_in_with_id_nature_com_requesting_email_profile_scope() throws Throwable {
        loginSteps.clickOnLinkToRequestEmailprofile();
    }

    @Given("^I enter email as \"([^\"]*)\" in login page$")
    public void i_enter_email_as_in_login_page(String email) {
        loginSteps.enterEmail(email);
    }

    @Given("^I enter password as \"([^\"]*)\" in login page$")
    public void i_enter_password_as_in_login_page(String password) {
        loginSteps.enterPassword(password);
    }

    @When("^I click on submit button$")
    public void i_click_on_submit_button() {
        loginSteps.clickOnSubmit();
    }

    @Then("^login button should be disabled$")
    public void login_button_should_be_disabled() {
        loginSteps.loginBtnShouldBeDisabled();
    }


}
