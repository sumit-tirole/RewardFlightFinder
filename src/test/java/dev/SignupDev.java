package dev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.flightfinder.genericutility.BaseClass;
import com.flightfinder.genericutility.FileUtility;
import com.flightfinder.pomrepo.CreateAlertElements;
import com.flightfinder.pomrepo.SignUpElements;


public class SignupDev extends BaseClass {
	FileUtility fileUtils = new FileUtility();
	public static String outboundDate;
	public Logger log = LogManager.getLogger(SignupDev.class);
		
	@Test(priority=1, enabled = true)
	public void signup_Bronze_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		log.info("Navigated to the Url");
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		log.info("Clicked accept cookies button");
		element.getSignUpButton().click();
		log.info("Clicked signup button");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getBronzeSubscribeButton());}
		catch (Exception e) {}
		log.info("Clicked bronze subscribe button");
		element.getEmailTextField().sendKeys("TestBronzeDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
		log.info("Entered random email");
		element.getContinueButton().click();
		log.info("Clicked continue button");
		element.getPasswordTextField().sendKeys("Test@123");
		log.info("Entered password");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        log.info("Entered password again");
        element.getSetPassword().click();
        log.info("Clicked set password button");
        element.getFirstNameTextField().sendKeys("John");
        log.info("Entered first name");
        element.getLastNameTextField().sendKeys("Doe");
        log.info("Entered last name");
        element.getSignUpButton2().click();
        log.info("Clicked signup button");
        System.out.println(element.getConfirmSignUp().getText());  //Printing successfull signup message to console
        element.getContinueAfterSignUpButton().click();
        log.info("Closed the browser");
        
        }
	
	@Test(priority=2, enabled = true)
	public void signup_SilverYearly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		log.info("Navigated to the url");
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		log.info("Clicked accept cookies button");
		element.getSignUpButton().click();
		log.info("Clicked signup button");
      	JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getSilverSubscribeButton());}
		catch (Exception e) {}
		log.info("Clicked silver subscribe button");
		element.getEmailTextField().sendKeys("TestSilverDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
		log.info("Entered random email");
		element.getContinueButton().click();
		log.info("Clicked continue button");
        element.getPasswordTextField().sendKeys("Test@123");
        log.info("Entered password");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        log.info("Entered password again");
        element.getSetPassword().click();
        log.info("Clicked set password button");
        element.getFirstNameTextField().sendKeys("John");
        log.info("Entered first name");
        element.getLastNameTextField().sendKeys("Doe");
        log.info("Entered last name");
        element.getSignUpButton2().click();
        log.info("Clicked signup button");
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        log.info("Clicked proceed to checkout button");
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        log.info("Entered billing name");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        log.info("Entered zip code");
        element.getNextButton().click();
        log.info("Clicked next button");
        element.getCardNumberTextField().sendKeys("4242424242424242",Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        log.info("Entered card number");
        element.getExpiryTextField().sendKeys("1224");
        log.info("Entered expiry date");
        element.getCvvTextField().sendKeys("123");
        log.info("Entered cvv");
        element.getNextButton2().click();
        log.info("Clicked next button");
        element.getSubscribeButton().click();
        log.info("Clicked subscribe button");
        System.out.println(element.getConfirmSilverSignup().getText());
        element.getContinueSilverSignupButton().click();
        log.info("Clicked continue signup button");
	}
	
	@Test(priority=3, enabled = true)
	public void signup_GoldYearly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		log.info("Navigated to the url");
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		log.info("Clicked accept cookies button");
		element.getSignUpButton().click();
		log.info("Clicked signup button");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getGoldSubscribeButton());}
		catch (Exception e) {}
		log.info("Clicked gold subscribe button");
		element.getEmailTextField().sendKeys("TestGoldDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
		log.info("Entered random email");
		element.getContinueButton().click();
		log.info("Clicked continue button");
        element.getPasswordTextField().sendKeys("Test@123");
        log.info("Entered password");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        log.info("Entered password again");
        element.getSetPassword().click();
        log.info("Clicked set password button");
        element.getFirstNameTextField().sendKeys("John");
        element.getLastNameTextField().sendKeys("Doe");
        log.info("Entered first name and last name");
        element.getSignUpButton2().click();
        log.info("Clicked signup button");
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        log.info("Clicked proceed to checkout button");
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        log.info("Entered billing name");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        log.info("Entered zip code");
        element.getNextButton().click();
        log.info("Clicked next button");
        element.getCardNumberTextField().sendKeys("4242424242424242", Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        log.info("Entered card number");
        element.getExpiryTextField().sendKeys("1224");
        log.info("Entered expiry date");
        element.getCvvTextField().sendKeys("123");
        log.info("Entered cvv number");
        element.getNextButton2().click();
        log.info("Clicked next button");
        element.getSubscribeButton().click();
        log.info("Clicked subscribe button");
        System.out.println(element.getConfirmSilverSignup().getText());
        element.getContinueSilverSignupButton().click();
        log.info("Clicked continue signup button");
	}
	
	@Test(priority=4, enabled = true)
	public void signup_SilverMonthly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		log.info("Navigated to the url");
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		log.info("Clicked accept cookies button");
		element.getSignUpButton().click();
		log.info("Clicked signup button");
		WebElement button = driver.findElement(By.xpath("//span[@class='slider round']"));
		button.click();
      	JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getSilverSubscribeButton());}
		catch (Exception e) {}
		log.info("Clicked silver subscribe button");
		element.getEmailTextField().sendKeys("TestSilverMonthlyDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
		log.info("Entered random email");
		element.getContinueButton().click();
		log.info("Clicked continue button");
        element.getPasswordTextField().sendKeys("Test@123");
        log.info("Entered password");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        log.info("Entered password again");
        element.getSetPassword().click();
        log.info("Clicked set password button");
        element.getFirstNameTextField().sendKeys("John");
        log.info("Entered first name");
        element.getLastNameTextField().sendKeys("Doe");
        log.info("Entered last name");
        element.getSignUpButton2().click();
        log.info("Clicked signup button");
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        log.info("Clicked proceed to checkout button");
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        log.info("Entered billing name");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        log.info("Entered zip code");
        element.getNextButton().click();
        log.info("Clicked next button");
        element.getCardNumberTextField().sendKeys("4242424242424242",Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        log.info("Entered card number");
        element.getExpiryTextField().sendKeys("1224");
        log.info("Entered expiry date");
        element.getCvvTextField().sendKeys("123");
        log.info("Entered cvv");
        element.getNextButton2().click();
        log.info("Clicked next button");
        element.getSubscribeButton().click();
        log.info("Clicked subscribe button");
        System.out.println(element.getConfirmSilverSignup().getText());
        element.getContinueSilverSignupButton().click();
        log.info("Clicked continue signup button");
	}
	
	@Test(priority=5, enabled = true)
	public void signup_GoldMonthly_Dev() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("devurl"));}
		catch(WebDriverException e) {}
		log.info("Navigated to the url");
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		log.info("Clicked accept cookies button");
		element.getSignUpButton().click();
		log.info("Clicked signup button");
		WebElement button = driver.findElement(By.xpath("//span[@class='slider round']"));
		button.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getGoldSubscribeButton());}
		catch (Exception e) {}
		log.info("Clicked gold subscribe button");
		element.getEmailTextField().sendKeys("TestGoldMonthlyDev"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
		log.info("Entered random email");
		element.getContinueButton().click();
		log.info("Clicked continue button");
        element.getPasswordTextField().sendKeys("Test@123");
        log.info("Entered password");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        log.info("Entered password again");
        element.getSetPassword().click();
        log.info("Clicked set password button");
        element.getFirstNameTextField().sendKeys("John");
        element.getLastNameTextField().sendKeys("Doe");
        log.info("Entered first name and last name");
        element.getSignUpButton2().click();
        log.info("Clicked signup button");
        driver.switchTo().frame(element.getFrameElement());
        element.getProceedToCheckoutButton().click();
        log.info("Clicked proceed to checkout button");
        element.getBillingName().sendKeys("John");
        element.getBillingLastName().sendKeys("Doe");
        log.info("Entered billing name");
        element.getZipCode().sendKeys(fileUtils.readFromPropertyFile("postCode"));
        log.info("Entered zip code");
        element.getNextButton().click();
        log.info("Clicked next button");
        element.getCardNumberTextField().sendKeys("4242424242424242", Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        log.info("Entered card number");
        element.getExpiryTextField().sendKeys("1224");
        log.info("Entered expiry date");
        element.getCvvTextField().sendKeys("123");
        log.info("Entered cvv number");
        element.getNextButton2().click();
        log.info("Clicked next button");
        element.getSubscribeButton().click();
        log.info("Clicked subscribe button");
        System.out.println(element.getConfirmSilverSignup().getText());
        element.getContinueSilverSignupButton().click();
        log.info("Clicked continue signup button");
	}
	
		
	}
	
	
