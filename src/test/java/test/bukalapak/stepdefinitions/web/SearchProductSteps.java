package test.bukalapak.stepdefinitions.web;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.bukalapak.pages.web.HomePage;

public class SearchProductSteps {
    @Autowired
    HomePage homePage;

    @When("user input existing product {string}")
    public void userInputExistingProduct(String name) {
        homePage.inputSearchBar(name);
    }

    @Then("user see search result product {string}")
    public void userSeeSearchResultProduct(String name) {
        boolean actual = homePage.isSearchResultDisplay(name);
        Assert.assertTrue(actual);
    }
}
