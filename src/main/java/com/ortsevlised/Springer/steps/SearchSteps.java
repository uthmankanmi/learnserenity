package com.ortsevlised.Springer.steps;

import com.ortsevlised.Springer.Constants;
import com.ortsevlised.Springer.pages.SearchPage;
import com.ortsevlised.Springer.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Jorge on 16/12/2015.
 */
public class SearchSteps extends ScenarioSteps {

    LoginPage loginPage;
    SearchPage searchPage;

    @Step("Going to Springer page")
    public void goToSpringerPage() {
        searchPage.open();
    }

    @Step("Clicking on Loging link")
    public void goToLogin() {
        searchPage.linkRegister.click();
        searchPage.waitFor(loginPage.inputLoginEmail);

    }

    @Step("I perform a valid search")
    public void searchValidKeyWord(String searchType) {
        switch (searchType) {
            case Constants.EMPTY:
                searchPage.searching("");
                break;
            case Constants.SPECIFIC:
                searchPage.searching(Constants.SPECIFIC_SEARCH);
                break;
            case Constants.NO_RESULTS:
                searchPage.searching(Constants.NO_RESULT_SEARCH);
                break;
            default:
                throw new RuntimeException("That option is not valid");
        }
    }

    @Step("Entering a length bigger than allowed")
    public void searchLengths() {
        searchPage.searching(RandomStringUtils.randomAlphanumeric(Constants.MAX_LENGTH + 1));
    }

    @Step("Expecting validation error")
    public void getResultError() {
        //This is going to fail as the application is not handling errors properly.
       Assert.assertThat("The validation error is not displayed",searchPage.alertValidationError.isVisible(),is (true));
    }

    @Step("Getting the results")
    public void getResults(String searchType) {
        Assert.assertThat("The result page is not visible", searchPage.divResults.isVisible(), is(true));
        switch (searchType) {
            case Constants.EMPTY:
                //Empty returns the complete list of results
                Assert.assertThat("The result page is not visible", searchPage.divNumberOfResults.isVisible(), is(true));
                Assert.assertThat("The sort by drop down is not visible", searchPage.dropDownSortBy.isVisible(), is(true));
                Assert.assertThat("The date published is not visible", searchPage.divDatePublished.isVisible(), is(true));
                Assert.assertThat("The pagination is not visible", searchPage.formPagination.isVisible(), is(true));
                Assert.assertThat("The list of result is not visible", searchPage.listOfResult.isVisible(), is(true));
                break;
            case Constants.SPECIFIC:
                Assert.assertThat("The result page is not visible", searchPage.divNumberOfResults.isVisible(), is(true));
                //This might be a bug, what's the sens of the sort by order when there's only one result?
                Assert.assertThat("The sort by drop down is not visible", searchPage.dropDownSortBy.isVisible(), is(true));
                Assert.assertThat("The date published is not visible", searchPage.divDatePublished.isVisible(), is(true));
                Assert.assertThat("The pagination is visible", searchPage.formPagination.isVisible(), is(false));
                Assert.assertThat("The list of result is not visible", searchPage.listOfResult.isVisible(), is(true));
                break;
            case Constants.NO_RESULTS:
                Assert.assertThat("The result page is not visible", searchPage.divNumberOfResults.isVisible(), is(true));
                Assert.assertThat("The sort by drop down is visible", searchPage.dropDownSortBy.isVisible(), is(false));
                Assert.assertThat("The date published is visible", searchPage.divDatePublished.isVisible(), is(false));
                Assert.assertThat("The list of result is not visible", searchPage.listOfResult.isVisible(), is(true));
                Assert.assertThat("The list of result is not visible", searchPage.listResults.size(), is(0));
                Assert.assertThat("The pagination is visible", searchPage.formPagination.isVisible(), is(false));
                break;
            default:
                throw new RuntimeException("That option is not valid");
        }
    }
}


