package utilities;

import controllers.DeviceCapability;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Element extends DeviceCapability {

    static int waitInSeconds = 15;
    private Element(){

    }

    public static WebElement getElement(By element){
        WebElement webElement = null;
        try{
            webElement = driver.findElement(element);
            return webElement;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return webElement;
    }

    /**
     * this method click using Web Element
     * @param element
     * @param elementName
     */
    public static void clickUsingWebElement(WebElement element, String elementName){
        try{
            ExplicitWaiting.explicitWaitElementToBeClickable(element,waitInSeconds);
            element.click();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method return text of element
     * @param element
     * @return
     */
    public static String getText(WebElement element){
        try{
            ExplicitWaiting.explicitWaitVisibilityOfElement(element,waitInSeconds);
            return element.getText().trim();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }

    /**
     * This method is to verify element is visible or not
     * @param element
     * @param elementName
     * @return
     */
    public static boolean isVisibleUsingWebElement(WebElement element, String elementName) {
        try {

            ExplicitWaiting.explicitWaitVisibilityOfElement(element, waitInSeconds);
            if (element.isDisplayed()) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    /**
     * This method is for entering the text
     * @param element
     * @param text
     * @param elementName
     */

    public static void enterText(WebElement element, String text, String elementName){
        try{
            ExplicitWaiting.explicitWaitVisibilityOfElement(element,waitInSeconds);
            if(element.isEnabled()){
                element.clear();
                element.sendKeys(text, Keys.ENTER);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * @return
     */
    public static String getAttributeValue(WebElement element, String elementName){
        try{
            ExplicitWaiting.explicitWaitVisibilityOfElement(element, waitInSeconds);
            return element.getAttribute("value").trim();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return "";
    }
    public static String getAttributeByName(WebElement element, String elementName){
        try{
            ExplicitWaiting.explicitWaitVisibilityOfElement(element,waitInSeconds);
            return element.getAttribute("name").trim();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return "";

    }
}
