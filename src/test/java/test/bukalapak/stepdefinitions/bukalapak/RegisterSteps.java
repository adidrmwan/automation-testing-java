package test.bukalapak.stepdefinitions.bukalapak;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.bukalapak.pages.HomePage;
import test.bukalapak.pages.RegisterPage;

public class RegisterSteps {
    @Autowired
    HomePage homePage;
    @Autowired
    RegisterPage registerPage;

    @When("user click register button")
    public void userClickRegisterButton() {
        homePage.clickRegisterButton();
    }

    @Then("user on register page")
    public void userOnRegisterPage() {
        boolean actual = registerPage.isOnPage();
        Assert.assertTrue(actual);
    }

    @When("user input invalid email")
    public void userInputInvalidEmail() {
        registerPage.inputEmail("adidrmwan17");
    }

    @And("user click register button on register page")
    public void userClickRegisterButtonOnRegisterPage() {
        registerPage.clickRegisterButton();
    }

    @Then("user see error message email or phone not suitable")
    public void userSeeErrorMessageEmailOrPhoneNotSuitable() {
        String expected = "Format nomor handphone atau email tidak sesuai.";
        String actual = registerPage.getErrorMessage();
        Assert.assertEquals(expected, actual);
    }


}
