package com.ortsevlised.Springer.jbehave.BusinessLogic;

import com.ortsevlised.Springer.steps.SearchSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Jorge on 16/12/2015.
 */
public class SearchDefinitions {

    @Steps
    SearchSteps searchSteps;

    @When("I perform a <searchType> search")
        public void searchValidKeyWord(String searchType){
        searchSteps.searchValidKeyWord(searchType);
    }

    @When("I try to search for an amount of characteres bigger than the allowed one")
    public void searchLength(){
        searchSteps.searchLengths();
    }

    @Then ("an error is displayed")
    public void searchError(){
        searchSteps.getResultError();
    }
    @Then("a <searchType> result is displayed")
    public void getResults(String searchType){
        searchSteps.getResults(searchType);
    }
}
