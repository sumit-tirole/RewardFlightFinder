package testCases;

import java.time.Duration;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.flightfinder.genericutility.BaseClass;
import com.flightfinder.genericutility.FileUtility;
import com.flightfinder.pomrepo.AppleLogin;
import com.flightfinder.pomrepo.CreateAlertElements;
import com.flightfinder.pomrepo.DeleteAlertElements;
import com.flightfinder.pomrepo.EditAlertElements;
import com.flightfinder.pomrepo.FacebookLogin;
import com.flightfinder.pomrepo.GoogleLogin;
import com.flightfinder.pomrepo.SignUpElements;



public class TestClass1 extends BaseClass {
	FileUtility fileUtils = new FileUtility();
	public static String outboundDate;
	public Logger log = LogManager.getLogger(TestClass1.class);
	
	
	@Test(priority=1, enabled = true)
	public void signUpBronze() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
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
		element.getEmailTextField().sendKeys("TestSeleniumBronze"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
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
	public void signUpSilver() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
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
		element.getEmailTextField().sendKeys("TestSeleniumSilver"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
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
	public void signUpGold() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
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
		element.getEmailTextField().sendKeys("TestSeleniumGold"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
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
	public void loginInValidCredentials() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("email"));
		element.getPasswordTextField().sendKeys("ABC@123");
		element.getSignInButton().click();
		
	}
	
	@Test(priority=5, enabled = true)
	public void loginValidCredentials() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodemail"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodpass"));
		element.getSignInButton().click();
		element.getAccountButton().click();
		element.getLogoutButton().click();
		
	}
	
	@Test(priority=6, enabled = true)
	public void loginWithGoogle() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		GoogleLogin element1 = new GoogleLogin(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element1.getGoogleSignInButton().click();
		Thread.sleep(2000);
		Set<String> windows= driver.getWindowHandles();
		
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			}
			else {
				break;
			}
		}
		
		element1.getGoogleEmailTextField().sendKeys(fileUtils.readFromPropertyFile("gmail"));
		element1.getNextButton().click();
		element1.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("gmailpassword"));
		element1.getNextButton().click();
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			break;
			}
		}
		element.getAccountButton().click();
		element.getLogoutButton().click();
		
	}
	
	@Test(priority=7, enabled = true) 
	public void loginWithFacebook() throws Throwable{
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		FacebookLogin element1 = new FacebookLogin(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element1.getFbSignInButton().click();
		Thread.sleep(2000);
		
		Set<String> windows= driver.getWindowHandles();
		
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			}
			else {
				break;
			}
		}
		element1.getFbEmailTextField().sendKeys(fileUtils.readFromPropertyFile("facebookmail"));
		element1.getFbPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("facebookpassword"));
		element1.getFbLoginButton().click();
		
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			break;
			}
		}
		element.getAccountButton().click();
		element.getLogoutButton().click();
		
	}
	
	@Test(enabled = false, priority=8) 
	public void loginWithApple() throws Throwable{
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		AppleLogin element1 = new AppleLogin(driver);
		
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element1.getAppleSignInButton().click();
		Set<String> windows= driver.getWindowHandles();
		
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			}
			else {
				break;
			}
		}
		element1.getAppleEmailField().sendKeys(fileUtils.readFromPropertyFile("appleid"));
		element1.getAppleEmailField().sendKeys(Keys.ENTER);
		element1.getContinueWithPasswordButton().click();
		element1.getApplePasswordField().sendKeys(fileUtils.readFromPropertyFile("applepassword"));
		element1.getApplePasswordField().sendKeys(Keys.ENTER);
		
		
		
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			break;
			}
		}
		element.getAccountButton().click();
		element.getLogoutButton().click();
		
	}
	
	
	
	@Test(priority=9, enabled = true)
	public void createAlert() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("email"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
		element.getSignInButton().click();
		Actions action = new Actions(driver);
		action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
		element.getSearchButton().click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='full-page-loader-comp text-center']"))));
		element.getCreateAlertButton().click();
		element.getDepartStartDate().click();
		element.getNextMonth().click();
		element.getStartDate().click();
		element.getEndDate().click();
		element.getreturnStartDate().click();
		element.getNextMonth().click();
		element.getStartDate().click();
		element.getEndDate().click();
		element.getCreateAlertButtonPopup().click();
		System.out.println(element.getAlertmsg().getText());
		outboundDate = driver.findElement(By.xpath("(//div[@class='column text-left create-alert-modal-column column-dates'])[1]")).getText();
		element.getCloseAlertPopup().click();
		element.getAccountButton().click();
		element.getLogoutButton().click();
		}	
	
	
	@Test(priority=10, enabled = true)
	public void editAlert() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		DeleteAlertElements element1 = new DeleteAlertElements(driver);
		EditAlertElements element2 = new EditAlertElements(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("email"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
		element.getSignInButton().click();
		element1.getAlertButton().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element1.getEditAlertButton(outboundDate));}
		catch (Exception e) {}	
		element2.getAddPassengersButton().click();
		element2.getSaveButton().click();
		System.out.println(element2.getConfirmEditAlert().getText());
		element.getAccountButton().click();
		element.getLogoutButton().click();
	}
	
	@Test(priority=11, enabled = true)
	public void deleteAlert() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		DeleteAlertElements element1 = new DeleteAlertElements(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("email"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
		element.getSignInButton().click();
		element1.getAlertButton().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element1.getEditAlertButton(outboundDate));}
		catch (Exception e) {}	
		element1.getDeleteButton().click();
		element1.getDeleteButton().click();
		System.out.println(element.getAlertmsg().getText());
		element.getAccountButton().click();
		element.getLogoutButton().click();
		}
		
	
	@Test(priority=12, enabled=true)
	public void signUpSilvermonthly() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		element.getSignUpButton().click();
		WebElement button = driver.findElement(By.xpath("//span[@class='slider round']"));
		button.click();
      	JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getSilverSubscribeButton());}
		catch (Exception e) {}
		element.getEmailTextField().sendKeys("TestSeleniumSilvermonthly"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
        element.getContinueButton().click();
        element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Silver");
        element.getLastNameTextField().sendKeys("Monthly");
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
        element.getSubscribeButton().click();
        System.out.println(element.getConfirmSilverSignup().getText());
        element.getContinueSilverSignupButton().click();
	}
	
	
	@Test(priority=13 , enabled=true)
	public void signUpGoldmonthly() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		element.getSignUpButton().click();
		WebElement button = driver.findElement(By.xpath("//span[@class='slider round']"));
		button.click();
      	JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {jse.executeAsyncScript("arguments[0].click();",element.getGoldSubscribeButton());}
		catch (Exception e) {}
		element.getEmailTextField().sendKeys("TestSeleniumGoldmonthly"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
        element.getContinueButton().click();
        element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Gold");
        element.getLastNameTextField().sendKeys("Monthly");
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
        element.getSubscribeButton().click();
        System.out.println(element.getConfirmSilverSignup().getText());
        element.getContinueSilverSignupButton().click();
	}
	
	@Test(priority=14 , enabled=true)
	public void signUpBronzeprod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("bronzeurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		element1.getAcceptCookies().click();
		element.getEmailTextField().sendKeys("TestSeleniumBronze"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com");
        element.getContinueButton().click();
        element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Bronze");
        element.getLastNameTextField().sendKeys("Testing");
        element.getSignUpButton2().click();
        System.out.println(element.getConfirmSignUp().getText());  //Printing successfull signup message to console
        element.getContinueAfterSignUpButton().click();
	
	}
	
	@Test(priority=15 , enabled=true)
	public void popularArticlesCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		driver.findElement(By.xpath("//div[@data-for='blogs']")).click();
		WebElement popularArticles = driver.findElement(By.xpath("//div[@class='popular_article_inner cursor-pointer parentNode']"));
		Assert.assertEquals(popularArticles.isDisplayed(), true);
		
	}
	
	@Test(priority=16 , enabled=true)
	public void popularTopicsCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		driver.findElement(By.xpath("//div[@data-for='blogs']")).click();
		WebElement popularTopics = driver.findElement(By.xpath("//*[@id=\"bar-fixed\"]/div[2]/div/div/div[2]/div"));
		Assert.assertEquals(popularTopics.isDisplayed(), true);
		
	}
	
	@Test(priority=17 , enabled=true)
	public void popularBlogsCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		driver.findElement(By.xpath("//div[@data-for='blogs']")).click();
		WebElement popularBlogs = driver.findElement(By.xpath("//*[@id=\"blog-list\"]"));
		Assert.assertEquals(popularBlogs.isDisplayed(), true);
		
	}
	@Test(priority=18 , enabled=true)
	public void AppstoreImageCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement AppstoreImage = driver.findElement(By.xpath("//div[@class='app-store-img']"));
		Assert.assertEquals(AppstoreImage.isDisplayed(), true);
	
	}
	
@Test(priority=19 , enabled=true)
public void KbarHeader() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	WebElement KbarHeader = driver.findElement(By.xpath("//div[@class='kbar-header']"));
	Assert.assertEquals(KbarHeader.isDisplayed(), true);
}

@Test(priority=20 , enabled=true)
public void Guestuser() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));}
	catch(WebDriverException e) {}
	CreateAlertElements element = new CreateAlertElements(driver);
	element.getAcceptCookies().click();
	Actions action = new Actions(driver);
	action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
	element.getSearchButton().click();
	Thread.sleep(10000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(10000);
	WebElement Guestuser = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div/nav[2]/span[1]/div"));
	Assert.assertEquals(Guestuser.isDisplayed(), true);

}

@Test(priority=21 , enabled=true)
public void facebook() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
   // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    CreateAlertElements element1 = new CreateAlertElements(driver);
	element1.getAcceptCookies().click();
    Thread.sleep(5000);
	WebElement facebook = driver.findElement(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[1]"));
	try {js.executeAsyncScript("arguments[0].click();",facebook);}
	catch (Exception e) {}
	Thread.sleep(5000);
	
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	String fbUrl = driver.getCurrentUrl();
	System.out.println(fbUrl);
	Assert.assertEquals(fbUrl, "https://www.facebook.com/rewardflightfinder/");
}



@Test(priority=22 , enabled=true)
public void Twitter() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
   // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    CreateAlertElements element1 = new CreateAlertElements(driver);
	element1.getAcceptCookies().click();
    Thread.sleep(5000);
	WebElement twitter = driver.findElement(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[2]"));
	try {js.executeAsyncScript("arguments[0].click();",twitter);}
	catch (Exception e) {}
	Thread.sleep(5000);
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	String twitterurl = driver.getCurrentUrl();
	Assert.assertTrue(twitterurl.contains("https://twitter.com"), "url does not contain https://twitter.com");
	Assert.assertTrue(twitterurl.contains("rewardflightfdr"), "url does not contain rewardflightfdr");
}


@Test(priority=23 , enabled=true)
public void Linkedin() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
   // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    CreateAlertElements element1 = new CreateAlertElements(driver);
	element1.getAcceptCookies().click();
    Thread.sleep(5000);
	WebElement linkedin = driver.findElement(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[3]"));
	try {js.executeAsyncScript("arguments[0].click();",linkedin);}
	catch (Exception e) {}
	Thread.sleep(5000);
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	String linkedinurl = driver.getCurrentUrl();
	System.out.println(linkedinurl);
	Assert.assertEquals(linkedinurl, "https://www.linkedin.com/company/reward-flight-finder/");
}

@Test(priority=24 , enabled=true)
public void Instagram() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
   // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    CreateAlertElements element1 = new CreateAlertElements(driver);
	element1.getAcceptCookies().click();
    Thread.sleep(5000);
	WebElement instagram = driver.findElement(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[4]"));
	try {js.executeAsyncScript("arguments[0].click();",instagram);}
	catch (Exception e) {}
	Thread.sleep(5000);
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	String instagramurl = driver.getCurrentUrl();
	System.out.println(instagramurl);
	Assert.assertEquals(instagramurl, "https://www.instagram.com/rewardflightfinder/");
}



@Test(priority=25 , enabled=true)
public void GooglePlay() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
   // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    CreateAlertElements element1 = new CreateAlertElements(driver);
	element1.getAcceptCookies().click();
    Thread.sleep(5000);
	WebElement playstoreimg = driver.findElement(By.xpath("//img[@src='https://rewardflightfinder.com/static/media/google-play.b6d3fc79.png']"));
	try {js.executeAsyncScript("arguments[0].click();",playstoreimg);}
	catch (Exception e) {}
	Thread.sleep(5000);
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	String playstore = driver.getCurrentUrl();
	System.out.println(playstore);
	Assert.assertEquals(playstore, "https://play.google.com/store/apps/details?id=com.rewardflightfinder.app.android");
}


@Test(priority=26 , enabled=true)
public void Applestore() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
   // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    CreateAlertElements element1 = new CreateAlertElements(driver);
	element1.getAcceptCookies().click();
    Thread.sleep(5000);
	WebElement applestoreimg = driver.findElement(By.xpath("//img[@src='https://rewardflightfinder.com/static/media/app-store-img.626b8ae3.png']"));
	try {js.executeAsyncScript("arguments[0].click();",applestoreimg);}
	catch (Exception e) {}
	Thread.sleep(5000);
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	String appstore = driver.getCurrentUrl();
	System.out.println(appstore);
	Assert.assertEquals(appstore, "https://apps.apple.com/us/app/reward-flight-finder/id1467629555");
	}
	

}
	
	
