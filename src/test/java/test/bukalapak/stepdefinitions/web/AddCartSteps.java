package test.bukalapak.stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.bukalapak.pages.web.HomePage;
import test.bukalapak.pages.web.ProductPage;

public class AddCartSteps {
    @Autowired
    HomePage homePage;
    @Autowired
    ProductPage productPage;


    @And("user select existing product {string}")
    public void userSelectExistingProduct(String name) {
        homePage.clickSpecProductName(name);
    }

    @Then("user on product page")
    public void userOnProductPage() {
        boolean actual = productPage.isOnPage();
        Assert.assertTrue(actual);
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton() {
        productPage.clickAddToCartButton();
    }
}
