package com.ortsevlised.Springer.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


/**
 * Created by Jorge on 16/12/2015.
 */
@DefaultUrl(LoginPage.SPRINGER_LOGIN_PAGE)

public class LoginPage extends BasePage {

    public static final String SPRINGER_LOGIN_PAGE = "https://testid-www.nature.com/index";


    @FindBy(xpath = ("//*[p='Log in with id.nature.com requesting email profile scope']"))
    public WebElementFacade requestEmailprofileLink;

    @FindBy(id = "login-email")
    public WebElementFacade emailInput;

    @FindBy(id = "login-password")
    public WebElementFacade passwordInput;

    @FindBy(css = "[type='submit']")
    public WebElementFacade submitBtn;



}



