package test.bukalapak.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.bukalapak.pageobject.BasePageObject;
import test.bukalapak.properties.ConfigProperties;

import java.util.List;

@Component("test.bukalapak.pages.web.HomePage")
public class HomePage extends BasePageObject {
    @Autowired
    ConfigProperties configProperties;

    private By loginButton() {
        return By.className("te-header-login");
    }

    private By registerButton() {
        return By.xpath("//p[contains(text(), 'Daftar')]");
    }

    private By searchBar() { return By.id("v-omnisearch__input"); }

    private By productName() { return By.cssSelector(".bl-product-card__description-name > p"); }

    private By specProductName(String name){
        return By.xpath(String.format("//div[@class='bl-product-card__description-name']/p/a[contains(text(), '%s')]",name));
    }

    public void openPage() {
        goTo(configProperties.getWeb().getBaseUrl());
    }

    public void clickLoginButton() {
        onClick(loginButton());
    }

    public void clickRegisterButton() {
        onClick(registerButton());
    }

    public void inputSearchBar(String value) {
        onType(searchBar(), value, Keys.ENTER);
    }

    public boolean isSearchResultDisplay(String value) {
        List<WebElement> elementList = waitUntilPresences(productName());
        int temp = elementList.size();
        for (WebElement element : elementList) {
            if (!element.getText().equalsIgnoreCase(value)) {
                temp--;
            }
        }
        return temp > 0;
    }

    public void clickSpecProductName(String name) {
        onClick(specProductName(name));
    }
}
