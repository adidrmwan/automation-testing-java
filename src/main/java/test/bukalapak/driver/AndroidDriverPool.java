package test.bukalapak.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Data;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.bukalapak.properties.ConfigProperties;
import test.bukalapak.properties.DriverAndroidProperties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Data
@Service
public class AndroidDriverPool {
    @Autowired
    DriverAndroidProperties driverAndroidProperties;

    @Autowired
    ConfigProperties configProperties;

    private HashMap<String, AndroidDriver> androidDriver = new HashMap<>();

    public void setAndroidDriver(String sessionName, AndroidDriver androidDriver) {
        this.androidDriver.put(sessionName, androidDriver);
    }

    public AndroidDriver getAndroidDriver(String sessionName) {
        AndroidDriver androidDriver = this.androidDriver.getOrDefault(sessionName, null);
        if (androidDriver == null) {
            androidDriver = initiateAndroidDriver();
        }
        return androidDriver;
    }


    public AndroidDriver initiateAndroidDriver() {
        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        String appiumUrl = driverAndroidProperties.getAppiumUrl();

        caps.setCapability(
                AndroidMobileCapabilityType.PLATFORM_NAME, driverAndroidProperties.getPlatformName());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, driverAndroidProperties.getDeviceName());
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, driverAndroidProperties.isAutoGrantPermissions());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, driverAndroidProperties.getAutomationName());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configProperties.getAndroid().getAppPackage());
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configProperties.getAndroid().getAppActivity());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + File.separator + configProperties.getAndroid().getAppPath());

        try {
            driver = new AndroidDriver<AndroidElement>(new URL(appiumUrl), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
