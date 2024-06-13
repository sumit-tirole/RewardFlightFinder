package dev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.flightfinder.genericutility.BaseClass;
import com.flightfinder.genericutility.FileUtility;
import com.flightfinder.pomrepo.CreateAlertElements;
import com.flightfinder.pomrepo.SignUpElements;
import listeners.ExtentReportListener;
import listeners.ScreenshotUtility;


public class SignupDev extends BaseClass {
	FileUtility fileUtils = new FileUtility();
	public static String outboundDate;
	public Logger log = LogManager.getLogger(SignupDev.class);
		
	@Test(priority=1, enabled = true, description="Signup as a Bronze user on Dev environment" )
	public void signup_Bronze_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		try{
            element1.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element1.getAcceptCookies().click();
        }
		element.getSignUpButton().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getBronzeSubscribeButton());}
		catch (Exception e) {}
		String email = "TestBronzeDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com";
		element.getEmailTextField().sendKeys(email);
		element.getContinueButton().click();
		element.getPasswordTextField().sendKeys("Test@123");
		element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Dev");
        element.getLastNameTextField().sendKeys("Bronze");
        element.getSignUpButton2().click();
        try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
        System.out.println(element.getConfirmSignUp().getText());  //Printing successfull signup message to console
        String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
    	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Bronze signup validation");
        element.getContinueAfterSignUpButton().click();
        ExtentReportListener.logMessage("Email: "+email);
        }
	
	@Test(priority=2, enabled = true, description="Signup as a Silver Yearly user on dev environment",invocationCount = 1)
	public void signup_SilverYearly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		try{
            element1.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element1.getAcceptCookies().click();
        }
		element.getSignUpButton().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getSilverSubscribeButton());}
		catch (Exception e) {}
		String email = "TestSilverDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com";
		element.getEmailTextField().sendKeys(email);
		element.getContinueButton().click();
		element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Dev");
        element.getLastNameTextField().sendKeys("Silveryearly");
        element.getSignUpButton2().click();
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        element.getNextButton().click();
        element.getCardNumberTextField().sendKeys("4242424242424242",Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        element.getExpiryTextField().sendKeys("1224");
        element.getCvvTextField().sendKeys("123");
        element.getNextButton2().click();
        try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
        element.getSubscribeButton().click();
        System.out.println(element.getConfirmSilverSignup().getText());
        String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
    	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for silver yearly signup validation");
        element.getContinueSilverSignupButton().click();
        ExtentReportListener.logMessage("Email: "+email);
	}
	
	@Test(priority=3, enabled = true, description="Signup as a Gold Yearly user on dev environment",invocationCount = 1)
	public void signup_GoldYearly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		try{
            element1.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element1.getAcceptCookies().click();
        }
		element.getSignUpButton().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getGoldSubscribeButton());}
		catch (Exception e) {}
		String email = "TestGoldDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com";
		element.getEmailTextField().sendKeys(email);
		element.getContinueButton().click();
		element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Dev");
        element.getLastNameTextField().sendKeys("Goldyearly");
        element.getSignUpButton2().click();
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        element.getNextButton().click();
        element.getCardNumberTextField().sendKeys("4242424242424242", Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        element.getExpiryTextField().sendKeys("1224");
        element.getCvvTextField().sendKeys("123");
        element.getNextButton2().click();
        try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
        element.getSubscribeButton().click();
        System.out.println(element.getConfirmSilverSignup().getText());
        String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
    	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Gold yearly signup  validation");
        element.getContinueSilverSignupButton().click();
        ExtentReportListener.logMessage("Email: "+email);
	}
	
	@Test(priority=4, enabled = true, description="Signup as a Silver Monthly user on dev environment",invocationCount = 1)
	public void signup_SilverMonthly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		try{
            element1.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element1.getAcceptCookies().click();
        }
		element.getSignUpButton().click();
		WebElement button = driver.findElement(By.xpath("//span[@class='slider round']"));
		button.click();
      	JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getSilverSubscribeButton());}
		catch (Exception e) {}
		String email = "TestSilverMonthlyDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com";
		element.getEmailTextField().sendKeys(email);
		element.getContinueButton().click();
		element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Dev");
        element.getLastNameTextField().sendKeys("Silvermonthly");
        element.getSignUpButton2().click();
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        element.getNextButton().click();
        element.getCardNumberTextField().sendKeys("4242424242424242",Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        element.getExpiryTextField().sendKeys("1224");
        element.getCvvTextField().sendKeys("123");
        element.getNextButton2().click();
        try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
        element.getSubscribeButton().click();
        System.out.println(element.getConfirmSilverSignup().getText());
        String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
    	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Silver monthly signup validation");
        element.getContinueSilverSignupButton().click();
        ExtentReportListener.logMessage("Email: "+email);
	}
	
	@Test(priority=5, enabled = true, description="Signup as a Gold Monthly user on dev environment",invocationCount = 1)
	public void signup_GoldMonthly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		try{
            element1.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element1.getAcceptCookies().click();
        }
		element.getSignUpButton().click();
		WebElement button = driver.findElement(By.xpath("//span[@class='slider round']"));
		button.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getGoldSubscribeButton());}
		catch (Exception e) {}
		String email = "TestGoldMonthlyDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com";
		element.getEmailTextField().sendKeys(email);
		element.getContinueButton().click();
		element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Dev");
        element.getLastNameTextField().sendKeys("Goldmonthly");
        element.getSignUpButton2().click();
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        element.getNextButton().click();
        element.getCardNumberTextField().sendKeys("4242424242424242", Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        element.getExpiryTextField().sendKeys("1224");
        element.getCvvTextField().sendKeys("123");
        element.getNextButton2().click();
        try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
        element.getSubscribeButton().click();
        System.out.println(element.getConfirmSilverSignup().getText());
        String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
    	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Gold monthly validation");
        element.getContinueSilverSignupButton().click();
        ExtentReportListener.logMessage("Email: "+email);
	}
	
}
	
	
