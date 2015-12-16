package com.ortsevlised.Springer.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;


import java.util.List;


/**
 * Created by Jorge on 16/12/2015.
 */

@DefaultUrl(SearchPage.SPRINGER_URL)

public class SearchPage extends PageObject {

    public static final String SPRINGER_URL = "http://link.springer.com/";

    @FindBy(id = "query")
    public WebElementFacade inputSearch;

    @FindBy(id = "search")
    public WebElementFacade btnSearch;

    @FindBy(id = "results")
    public WebElementFacade divResults;

    @FindBy(className = "number-of-search-results-and-search-terms")
    public WebElementFacade divNumberOfResults;

    @FindBy(id = "no-results-message")
    public WebElementFacade divNoResultMessage;

    @FindBy(id = "sort-results")
    public WebElementFacade dropDownSortBy;

    @FindBy(id = "date-facet")
    public WebElementFacade divDatePublished;

    @FindBy(className = "pagination")
    public WebElementFacade formPagination;

    @FindBy (id= "results-list")
    public WebElementFacade listOfResult;

    @FindBy (css= "#results-list >li")
    public List<WebElementFacade> listResults;

    @FindBy (css = "#global-search > img")
    public WebElementFacade loadingWheel;

    @FindBy (id= "register-link")
    public WebElementFacade linkRegister;

    //This element doesn't exist is just an example of something that could be used to handle a validation error.
    @FindBy (id= "validation-error")
    public WebElementFacade alertValidationError;

    /**
     * Searches the keyword passed in as parameter.
     * @param keyword
     */
    public void searching(String keyword){
        inputSearch.type(keyword);
        btnSearch.click();
        loadingWheel.waitUntilNotVisible();
    }
}