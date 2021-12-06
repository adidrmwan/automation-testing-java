package test.automation.stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.web.HomePage;
import test.automation.pages.web.LoginPage;
import test.automation.properties.UserProperties;

public class LoginSteps {

    @Autowired
    HomePage homePage;
    @Autowired
    LoginPage loginPage;
    @Autowired
    UserProperties userProperties;

    @Given("user open bukalapak homepage")
    public void userOpenBukalapakHomepage() {
        homePage.openPage();
    }

    @When("user click login button")
    public void userClickLoginButton() {
        homePage.clickLoginButton();
    }

    @Then("user on login page")
    public void userOnLoginPage() {
        boolean actual = loginPage.isOnPage();
        Assert.assertTrue(actual);
        String email = userProperties.getCustomer().get("email");
        System.out.println(email);
    }

    @When("user input email")
    public void userInputInvalidEmail() {
        String email = userProperties.getCustomer().get("email");
        loginPage.inputEmail(email);
    }

    @And("user input invalid password")
    public void userInputPassword() {
        loginPage.inputPassword("invalid-password");
    }

    @And("user click login button on login page")
    public void userClickLoginButtonOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @Then("user see error message invalid email or password")
    public void userSeeErrorMessageInvalidEmailOrPassword() {
        String actual = loginPage.getErrorMessage();
        String expected = "E-mail atau password yang kamu masukkan salah. Silakan coba lagi.";
        Assert.assertEquals(expected, actual);
    }
}
