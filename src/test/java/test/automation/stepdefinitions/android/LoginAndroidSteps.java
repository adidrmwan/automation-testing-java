package test.automation.stepdefinitions.android;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.android.LoginScreen;

public class LoginAndroidSteps {
    @Autowired
    LoginScreen loginScreen;

    @When("android user input unregistered email")
    public void androidUserInputUnregisteredEmail() {
        Faker faker = new Faker();
        String email = faker.name().username() + "@gmail.com";
        loginScreen.inputEmail(email);
    }

    @And("android user tap login button")
    public void androidUserTapLoginButton() {
        loginScreen.tapLoginButton();
    }
}
