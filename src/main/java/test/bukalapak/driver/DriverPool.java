package test.bukalapak.driver;

import io.appium.java_client.android.AndroidDriver;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@Component("test.bukalapak.driver.DriverPool")
public class DriverPool {
    private HashMap<String, AndroidDriver> android = new HashMap<>();
    private HashMap<String, WebDriver> web = new HashMap<>();

    public WebDriver getWebDriver() {
        return this.web.getOrDefault(Thread.currentThread().getName(), null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.web.put(Thread.currentThread().getName(), webDriver);
    }

    public AndroidDriver getAndroidDriver() {
        return this.android.get(Thread.currentThread().getName());
    }

    public void setAndroidDriver(AndroidDriver androidDriver) {
        this.android.put(Thread.currentThread().getName(), androidDriver);
    }
}
