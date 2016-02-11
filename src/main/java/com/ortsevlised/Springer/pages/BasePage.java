package com.ortsevlised.Springer.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage extends PageObject{

    /**
     * Sets the screen focus on the WebElementFacade passed.
     *
     * @param element
     */
    public WebElementFacade scrollToElement(WebElementFacade element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
        return waitFor(element);
    }

}
