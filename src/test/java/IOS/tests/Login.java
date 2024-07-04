package IOS.tests;
import controllers.DeviceCapability;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.LoginPage;
import utilities.Element;
import utilities.ExplicitWaiting;

public class Login extends DeviceCapability {

    @Test(priority = 1)
    public void verifyLoginWithValidEmailAndInvalidPassword(){
        ExplicitWaiting.waitForSeconds(3);
        LoginPage login = new LoginPage(driver);
        Element.clickUsingWebElement(login.iAmCouchOrHost,"I am coach or host");
        ExplicitWaiting.waitForSeconds(1);
        Element.clickUsingWebElement(login.goToLoginButton,"Go to Login Page");
        ExplicitWaiting.waitForSeconds(1);
        Assert.assertTrue(Element.isVisibleUsingWebElement(login.loginToYourAccountTitle,"Login Title"));
        Element.enterText(login.emailField,"rich+coach@clippd.io","Enter the email to login");
        Element.enterText(login.passwordField,"SpikemarkUser202","Enter the password to login");
        Element.clickUsingWebElement(login.LoginButton,"Click on login button");
        //verify login with invalid credentials
        Assert.assertTrue(Element.isVisibleUsingWebElement(login.loginToYourAccountTitle,"Login Title"));

    }
    @Test(priority = 2)
    public void verifyHomePageWithValidCredentails() throws InterruptedException {
        ExplicitWaiting.waitForSeconds(3);
        LoginPage login = new LoginPage(driver);
//        Element.clickUsingWebElement(login.iAmCouchOrHost,"I am coach or host");
//        ExplicitWaiting.waitForSeconds(1);
//        Element.clickUsingWebElement(login.goToLoginButton,"Go to Login Page");
//        ExplicitWaiting.waitForSeconds(1);
//        Assert.assertTrue(Element.isVisibleUsingWebElement(login.loginToYourAccountTitle,"Login Title"));
        Element.enterText(login.emailField,"rich+coach@clippd.io","Enter the email to login");
        Element.enterText(login.passwordField,"SpikemarkUser2023","Enter the password to login");
        Element.clickUsingWebElement(login.LoginButton,"Click on login button");
        ExplicitWaiting.waitForSeconds(3);
        String profileNameText = Element.getAttributeValue(login.profileName,"Verify User profile name");
        Assert.assertEquals(profileNameText,"Rich Coach");
        String TournamenTitle = Element.getAttributeByName(login.TournamentTitle,"Verify Tournament Title Text");
        Assert.assertEquals(TournamenTitle,"Tournaments");
    }

}
