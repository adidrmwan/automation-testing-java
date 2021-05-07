package test.bukalapak.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.bukalapak.properties.DriverWebProperties;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Data
@Service
public class WebDriverPool {
    @Autowired
    DriverWebProperties driverWebProperties;

    private HashMap<String, WebDriver> webDriver = new HashMap<>();

    public WebDriver getWebDriver(String sessionName) {
        WebDriver webDriver = this.webDriver.getOrDefault(sessionName, null);
        if (webDriver == null) {
            webDriver = initiateWebDriver();
        }
        return webDriver;
    }

    public void setWebDriver(String sessionName, WebDriver webDriver) {
        this.webDriver.put(sessionName, webDriver);
    }

    public WebDriver initiateWebDriver() {
        WebDriver driver = null;
        String browser = driverWebProperties.getBrowser();

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(driverWebProperties.isAcceptInsecureCerts());
                firefoxOptions.setHeadless(driverWebProperties.isHeadless());
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setAcceptInsecureCerts(driverWebProperties.isAcceptInsecureCerts());
                chromeOptions.setHeadless(driverWebProperties.isHeadless());
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--incognito", "--start-maximized");
                //set desired capabilities
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        setWebDriver(Thread.currentThread().getName(), driver);
        return driver;
    }
}