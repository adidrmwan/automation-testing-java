package test.automation.pageobject;

import io.appium.java_client.android.AndroidDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.automation.driver.AndroidDriverPool;

@Component("test.automation.pageobject.AndroidPageObject")
public class AndroidPageObject extends BasePageObject {
    @Autowired
    AndroidDriverPool androidDriverPool;

    @Override
    public AndroidDriver getDriver() {
        if (this.driver.getAndroidDriver() == null) {
            this.driver.setAndroidDriver(this.androidDriverPool.create());
        }
        return this.driver.getAndroidDriver();
    }
}
