package test.bukalapak.pageobject;

import io.appium.java_client.android.AndroidDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.bukalapak.driver.AndroidDriverPool;

@Component("test.bukalapak.pageobject.AndroidPageObject")
public class AndroidPageObject extends BasePageObject{
    @Autowired
    AndroidDriverPool androidDriverPool;

    public AndroidDriver getDriver() {
        return androidDriverPool.getAndroidDriver(Thread.currentThread().getName());
    }
}
