package test.bukalapak.pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.bukalapak.pageobject.AndroidPageObject;

@Component("test.bukalapak.pages.android.RegisterScreen")
public class RegisterScreen extends AndroidPageObject {
    private By nameField() {
        return MobileBy.id("textInputEditTextName");
    }

    private By emailField() {
        return MobileBy.id("textInputEditTextName");
    }

    private By passwordField() {
        return MobileBy.id("textInputEditTextName");
    }

    private By confirmPasswordField() {
        return MobileBy.id("textInputEditTextName");
    }

    private By registerButton() {
        return MobileBy.id("textInputEditTextName");
    }

    private By errorMessage() {
        return MobileBy.xpath("//*[contains(@resource-id, \"textInputEditTextName\")]/following-sibling::android.widget.TextView");
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

    public boolean isErrorMessageDisplay() {
        return waitUntilVisible(errorMessage()).isDisplayed();
    }
}
