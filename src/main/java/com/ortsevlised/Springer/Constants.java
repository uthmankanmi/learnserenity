package com.ortsevlised.Springer;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by Jorge on 16/12/2015.
 */
public class Constants extends PageObject {

    /**
     * SEARCH PAGE CONSTANTS
     */

    //The maximum and minimum length should be defined in the requirements, I'm using 5000 as an example only.
    public static final int MAX_LENGTH = 5000;
    public static final String EMPTY = "Empty";
    public static final String SPECIFIC = "Specific";
    public static final String NO_RESULTS = "No results";
    public static final String NO_RESULT_SEARCH = "\"there is no result for this search\"";
    public static final String SPECIFIC_SEARCH = "Index to Hydrobiologia Volumes 251-384 (1993-1999)";

/**
 * LOGIN CONSTANTS
 */
 public static final String REGISTERED = "registered";

}

