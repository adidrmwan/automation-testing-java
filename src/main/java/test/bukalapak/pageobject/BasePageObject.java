package test.bukalapak.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import test.bukalapak.driver.DriverPool;
import test.bukalapak.driver.WebDriverPool;

import java.util.List;

public class BasePageObject {
    @Autowired
    DriverPool driver;
    @Autowired
    WebDriverPool webDriverPool;

    public WebDriver getDriver() {
        if (this.driver.getWebDriver() == null) {
            this.driver.setWebDriver(this.webDriverPool.create());
        }
        return this.driver.getWebDriver();
    }

    public WebDriverWait onWait() {
        return new WebDriverWait(getDriver(), 15);
    }

    public WebElement waitUntilClickable(By by) {
        return onWait().until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitUntilPresence(By by) {
        return onWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitUntilPresences(By by) {
        return onWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement waitUntilVisible(By by) {
        return onWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitUntilVisibles(By by) {
        return onWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void onClick(By by) {
        waitUntilClickable(by).click();
    }

    public void onType(By by, CharSequence... keysToSend) {
        waitUntilPresence(by).sendKeys(keysToSend);
    }

    public void onType(WebElement webElement, CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    public void clear(By by) {
        waitUntilPresence(by).clear();
    }

    public boolean isElementInvisible(By by) {
        return onWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void scrollTo(By by) {
        Locatable l = ((Locatable) this.waitUntilPresence(by));
        l.getCoordinates().inViewPort();
    }

    public void goTo(String url) {
        getDriver().get(url);
    }
}