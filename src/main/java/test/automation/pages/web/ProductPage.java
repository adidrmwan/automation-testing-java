package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.automation.pages.web.ProductPage")
public class ProductPage extends BasePageObject {
    private By productPage() {
        return By.id("section-main-product");
    }

    private By addToCartButton() {
        return By.className("c-main-product__action__cart");
    }

    public boolean isOnPage() {
        return waitUntilPresence(productPage()).isDisplayed();
    }

    public void clickAddToCartButton() {
        onClick(addToCartButton());
    }
}
