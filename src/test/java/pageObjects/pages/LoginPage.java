package pageObjects.pages;

import controllers.DeviceCapability;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Element;
import utilities.ExplicitWaiting;

public class LoginPage extends DeviceCapability {

     IOSDriver driver;

    public LoginPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSXCUITFindBy(accessibility = "I am a coach or host")
    public WebElement iAmCouchOrHost;

    @iOSXCUITFindBy(accessibility = "Go to Login")
    public WebElement goToLoginButton;

    @iOSXCUITFindBy(accessibility = "Login to your account")
    public WebElement loginToYourAccountTitle;

    @iOSXCUITFindBy(accessibility = "Email")
    public WebElement emailField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Password']/XCUIElementTypeSecureTextField")
    public WebElement passwordField;

    @iOSXCUITFindBy(accessibility = "Login")
    public WebElement LoginButton;

    @iOSXCUITFindBy(accessibility = "Rich Coach")
    public WebElement profileName;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Tournaments'])[1]")
    public WebElement TournamentTitle;

//    public void navigateAndLogin(){
////        iAmCouchOrHost.click();
////        goToLoginButton.click();
//        Element.clickUsingWebElement(iAmCouchOrHost,"I am coach or host");
//        ExplicitWaiting.waitForSeconds(2);
//        Element.clickUsingWebElement(goToLoginButton,"Go to Login Page");
//        ExplicitWaiting.waitForSeconds(1);
//        Assert.assertTrue(Element.isVisibleUsingWebElement(loginToYourAccountTitle,"Login Title"));
//    }

}
