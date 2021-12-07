package test.automation.pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.RegisterScreen")
public class RegisterScreen extends AndroidPageObject {
    private By nameField() {
        return MobileBy.id("textInputEditTextName");
    }

    private By emailField() {
        return MobileBy.id("textInputEditTextEmail");
    }

    private By passwordField() {
        return MobileBy.id("textInputEditTextPassword");
    }

    private By confirmPasswordField() {
        return MobileBy.id("textInputEditTextConfirmPassword");
    }

    private By registerButton() {
        return MobileBy.id("appCompatButtonRegister");
    }

    private By errorInvalidEmailMessage() {
        return MobileBy.xpath("//*[contains(@resource-id, 'textInputLayoutEmail')]/descendant::android.widget.TextView");
    }

    private By toastMessage() {
        return MobileBy.id("snackbar_text");
    }

    public boolean isOnPage() {
        return waitUntilPresence(registerButton()).isDisplayed();
    }

    public void inputName(String name) {
        onType(nameField(), name);
    }

    public void inputEmail(String email) {
        onType(emailField(), email);
    }

    public void inputPassword(String pass) {
        onType(passwordField(), pass);
    }

    public void inputConfirmPassword(String pass) {
        onType(confirmPasswordField(), pass);
    }

    public void tapRegisterButton() {
        onClick(registerButton());
    }

    public boolean isErrorInvalidEmailMessageDisplay() {
        return waitUntilVisible(errorInvalidEmailMessage()).isDisplayed();
    }

    public String getToastMessage() {
        return waitUntilVisible(toastMessage()).getText();
    }
}
