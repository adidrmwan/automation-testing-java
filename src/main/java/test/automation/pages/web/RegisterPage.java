package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.bukalapak.pages.web.RegisterScreen")
public class RegisterPage extends BasePageObject {
    private By title() {
        return By.xpath("//p[contains(text(), 'Daftar dulu, yuk')]");
    }

    private By inputField() {
        return By.cssSelector("input[class='bl-text-field__input']");
    }

    private By registerButton() {
        return By.xpath("//span[contains(text(), 'Daftar')]");
    }

    private By errorMessage() {
        return By.className("bl-text--error");
    }

    public boolean isOnPage() {
        return waitUntilPresence(title()).isDisplayed();
    }

    public void inputEmail(String email){
        onType(inputField(),email);
    }

    public void clickRegisterButton() {
        onClick(registerButton());
    }

    public String getErrorMessage() {
        return waitUntilVisible(errorMessage()).getText();
    }
}
