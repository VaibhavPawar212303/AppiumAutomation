package controllers;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class DeviceCapability {

    String userName = System.getenv("LT_USERNAME") == null ? "username" : System.getenv("LT_USERNAME"); //Add username here
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "accessKey" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here
    String app_id = System.getenv("LT_APP_ID") == null ? "lt://proverbial-ios" : System.getenv("LT_APP_ID");      //Enter your LambdaTest App ID at the place of lt://proverbial-android
    String grid_url = System.getenv("LT_GRID_URL") == null ? "mobile-hub.lambdatest.com" : System.getenv("LT_GRID_URL");

    protected static IOSDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    @org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    public AppiumDriver setUp(String device, String version, String platform) {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platformVersion", version);
            cap.setCapability("automationName","XCUITest");
            cap.setCapability("deviceName", device);
            cap.setCapability("platformName", platform);
            cap.setCapability("unicodeKeyboard",true);
            cap.setCapability("app", "/Users/mac/Documents/Omkar data/Live-scoreboard-app/AppiumAutomation/LiveScoring.app");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723"),cap);

            wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    @AfterClass
    public void quitDriver(){
        if(driver !=null){
            driver.quit();
        }
    }
}
