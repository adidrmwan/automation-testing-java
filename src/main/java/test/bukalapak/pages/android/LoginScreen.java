package test.bukalapak.pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.bukalapak.pageobject.AndroidPageObject;
import test.bukalapak.pageobject.BasePageObject;

@Component("test.bukalapak.pages.android.LoginScreen")
public class LoginScreen extends AndroidPageObject {
    private By registerLink() {
        return MobileBy.id("textViewLinkRegister");
    }

    private By loginButton() {
        return MobileBy.id("appCompatButtonLogin");
    }

    public boolean isOnPage() {
        return waitUntilPresence(loginButton()).isDisplayed();
    }

    public void tapRegisterLink() {
        onClick(registerLink());
    }
}
