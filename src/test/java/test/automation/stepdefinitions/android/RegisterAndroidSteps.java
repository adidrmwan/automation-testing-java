package test.automation.stepdefinitions.android;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import test.automation.pages.android.LoginScreen;
import test.automation.pages.android.RegisterScreen;

public class RegisterAndroidSteps {
    public static String password = "password!2";
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
        Faker faker = new Faker();
        String name = faker.name().firstName();
        registerScreen.inputName(name);
    }

    @And("android user input invalid email")
    public void androidUserInputInvalidEmail() {
        registerScreen.inputEmail(randUsername());
    }

    @And("android user input password")
    public void androidUserInputPassword() {
        registerScreen.inputPassword(password);
    }

    @And("android user input confirmation password")
    public void androidUserInputConfirmationPassword() {
        registerScreen.inputConfirmPassword(password);
    }

    @And("android user tap register button")
    public void androidUserTapRegisterButton() {
        registerScreen.tapRegisterButton();
    }

    @Then("android user see error message invalid email")
    public void androidUserSeeErrorMessageInvalidEmail() {
        boolean actual = registerScreen.isErrorInvalidEmailMessageDisplay();
        Assert.assertTrue(actual);
    }

    @And("android user input valid email")
    public void androidUserInputValidEmail() {
        String email = randUsername() + "@gmail.com";
        registerScreen.inputEmail(email);
    }

    @Then("android user see {string} message")
    public void androidUserSeeMessage(String message) {
        String actual = registerScreen.getToastMessage();
        Assert.assertEquals(actual, message);
    }

    private String randUsername() {
        Faker faker = new Faker();
        return faker.name().username();
    }

}
