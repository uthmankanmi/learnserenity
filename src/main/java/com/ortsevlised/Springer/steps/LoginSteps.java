package com.ortsevlised.Springer.steps;

import com.ortsevlised.Springer.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Jorge on 16/12/2015.
 */
public class LoginSteps extends ScenarioSteps {
    LoginPage loginPage;

    @Step("Logging in with valid credentials")
    public void loginWithValidCredentials() {
        loginPage.loginWithValidCredentials();
    }

    @Step("Verifying the user is logged in")
    public boolean verifyUserIsLoggedIn() {
        return loginPage.isUserLoggedIn();
    }

    @Step("Verifying the user is not logged in")
    public boolean verifyUserIsLoggedOut() {
       return loginPage.isUserLoggedOut();
    }
}


