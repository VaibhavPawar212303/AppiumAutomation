package utilities;

import controllers.DeviceCapability;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaiting extends DeviceCapability {

    public ExplicitWaiting(){

    }

    public static void explicitWaitElementToBeClickable(WebElement element, int Seconds){
        WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForSeconds(int timeoutInSeconds){
        try{
            Thread.sleep(timeoutInSeconds * 1000);
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public static void explicitWaitVisibilityOfElement(WebElement element, int Seconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
    }
}
