package test.bukalapak.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.bukalapak.pageobject.BasePageObject;

@Component("test.bukalapak.pages.web.ProductPage")
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
