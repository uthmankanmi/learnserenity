package com.ortsevlised.Springer.pages;

import com.ortsevlised.Springer.models.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


/**
 * Created by Jorge on 16/12/2015.
 */
@DefaultUrl(LoginPage.SPRINGER_LOGIN_PAGE)

public class LoginPage extends PageObject {
    public static final String SPRINGER_LOGIN_PAGE = "http://link.springer.com/signup-login";

    User user;

    @FindBy(id = "login-box-email")
    public WebElementFacade inputLoginEmail;

    @FindBy(id = "login-box-pw")
    public WebElementFacade inputLoginPassword;

    @FindBy(css = "#login-box .form-submit")
    public WebElementFacade btnLogIn;

    @FindBy(id = "user")
    public WebElementFacade btnUser;

    @FindBy(id = "register-link")
    public WebElementFacade btnSignIn;

    /**
     * Logging in with valid user
     *
     * @return
     */

    public void loginWithValidCredentials() {
        user = new User();
        inputLoginEmail.type(user.getEmail());
        inputLoginPassword.type(user.getPassword());
        btnLogIn.submit();
        waitFor(btnUser);
    }

    /**
     * Checking the user is logged in
     */
    public boolean isUserLoggedIn() {
        return !getDriver().manage().getCookieNamed("sim-user-token").getValue().isEmpty() && btnUser.isVisible();
    }

    /**
     * Checking the user is logged out
     */
    public boolean isUserLoggedOut() {
        return getDriver().manage().getCookieNamed("sim-user-token") == null;
    }
}



