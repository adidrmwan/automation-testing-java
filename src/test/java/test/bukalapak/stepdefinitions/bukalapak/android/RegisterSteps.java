package test.bukalapak.stepdefinitions.bukalapak.android;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import test.bukalapak.pages.android.LoginScreen;
import test.bukalapak.pages.android.RegisterScreen;

public class RegisterSteps {
    @Autowired
    LoginScreen loginScreen;
    @Autowired
    RegisterScreen registerScreen;
    @Given("android user on landing screen")
    public void androidUserOnLandingScreen() {
        boolean actual = loginScreen.isOnPage();
        Assert.assertTrue(actual);
    }

    @When("android user tap register link")
    public void androidUserTapRegisterLink() {
        loginScreen.tapRegisterLink();
    }

    @Then("android user on register screen")
    public void androidUserOnRegisterScreen() {
        boolean actual = registerScreen.isOnPage();
        Assert.assertTrue(actual);
    }

    @When("android user input name")
    public void androidUserInputName() {
        registerScreen.inputName("adi");
    }

    @And("android user input invalid email")
    public void androidUserInputInvalidEmail() {
        registerScreen.inputEmail("adi");
    }

    @And("android user input password")
    public void androidUserInputPassword() {
        registerScreen.inputPassword("adi");
    }

    @And("android user input confirmation password")
    public void androidUserInputConfirmationPassword() {
        registerScreen.inputConfirmPassword("adi");
    }

    @And("android user tap register button")
    public void androidUserTapRegisterButton() {
        registerScreen.tapRegisterButton();
    }

    @Then("android user see error message invalid email")
    public void androidUserSeeErrorMessageInvalidEmail() {
        boolean actual = registerScreen.isErrorMessageDisplay();
        Assert.assertTrue(actual);
    }
}
