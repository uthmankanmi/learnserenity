package com.ortsevlised.Springer.jbehave.BusinessLogic;

import com.ortsevlised.Springer.steps.LoginSteps;
import com.ortsevlised.Springer.steps.SearchSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

import static com.ortsevlised.Springer.Constants.*;

/**
 * Created by Jorge on 16/12/2015.
 */
public class LoginDefinitions {

    @Steps
    LoginSteps loginSteps;
    @Steps
    SearchSteps searchSteps;

    @Given("I'm a <userType> user on the Springer page")
    public void logInWithValidUser(String userType) {
        searchSteps.goToSpringerPage();
        if (userType.equals(REGISTERED)) {
            if (loginSteps.verifyUserIsLoggedOut()) {
                searchSteps.goToLogin();
                loginSteps.loginWithValidCredentials();
                loginSteps.verifyUserIsLoggedIn();
            }
        }
    }
}
