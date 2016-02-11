package com.ortsevlised.Springer.steps;

import com.ortsevlised.Springer.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


/**
 * Created by Jorge on 16/12/2015.
 */
public class LoginSteps extends ScenarioSteps {
    LoginPage loginPage;


    @Step("Opening identity Client Mock Page")
    public void navigateToIdentityClientMockPage() {
        loginPage.open();
        //  add(URL_KEY, UrlIdentityClient);;
    }

    @Step("Clicking Login with email profile scope")
    public void clickOnLinkToRequestEmailprofile() {
        loginPage.requestEmailprofileLink.click();
    }

    @Step("Entering email{0}")
    public void enterEmail(String email){
        loginPage.emailInput.sendKeys(email);
    }

    @Step("Entering password{0}")
    public void enterPassword(String password){
        loginPage.passwordInput.sendKeys(password);
    }
    @Step("Clicking submit")
    public void clickOnSubmit(){
        loginPage.scrollToElement(loginPage.submitBtn).click();
    }

    @Step("Verifying login button is disabled")
    public void loginBtnShouldBeDisabled(){
        loginPage.submitBtn.shouldNotBeEnabled();
    }



}


