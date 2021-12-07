package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.automation.pages.web.LoginPage")
public class LoginPage extends BasePageObject {
    private By title() {
        return By.xpath("//div[contains(@class,'heading')]/span");
    }

    private By email() {
        return By.id("user_session_username");
    }

    private By password() {
        return By.id("user_session_password");
    }

    private By loginButton() {
        return By.cssSelector("button[data-testid='submit-button']");
    }

    private By errorMessage() {
        return By.className("login-error");
    }

    public boolean isOnPage() {
        return waitUntilPresence(title()).isDisplayed();
    }

    public void inputEmail(String email) {
        onType(email(), email);
    }

    public void inputPassword(String password) {
        onType(password(), password);
    }

    public void clickLoginButton() {
        onClick(loginButton());
    }

    public String getErrorMessage() {
        return waitUntilVisible(errorMessage()).getText();
    }
}
