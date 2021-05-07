package test.bukalapak.hooks;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import test.bukalapak.driver.WebDriverPool;

public class BaseDriverHooks {

    @Autowired
    WebDriverPool webDriverPool;

    @After
    public void afterTest() {
        WebDriver webdriver = webDriverPool.getWebDriver()
                .getOrDefault(Thread.currentThread().getName(), null);

        // Quit the driver
        if (webdriver != null) {
            webdriver.quit();
            webDriverPool.setWebDriver(Thread.currentThread().getName(), null);
        }
    }
}