package prod;

import java.time.Duration;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.flightfinder.genericutility.BaseClass;
import com.flightfinder.genericutility.FileUtility;
import com.flightfinder.pomrepo.AppleLogin;
import com.flightfinder.pomrepo.CreateAlertElements;
import com.flightfinder.pomrepo.FacebookLogin;
import com.flightfinder.pomrepo.GoogleLogin;
import com.flightfinder.pomrepo.ProdElements;
import com.flightfinder.pomrepo.SignUpElements;



public class Regression extends BaseClass {
	FileUtility fileUtils = new FileUtility();
	public static String outboundDate;
	public Logger log = LogManager.getLogger(Regression.class);
	
	
		
	@Test(priority=1, enabled = true)
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
	
	@Test(priority=2, enabled = true)
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
	
	@Test(priority=3, enabled = true)
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
			System.out.println(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			}
			else {
				break;
			}
		}
			
		element1.getGoogleEmailTextField().sendKeys(fileUtils.readFromPropertyFile("gmail"));
		element1.getNextButton().click();
		element1.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("gmailpassword"));
		element1.getPasswordNext().click();
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			break;
			}
		}
		element.getAccountButton().click();
		element.getLogoutButton().click();
		
	}
	
	@Test(priority=4, enabled = true) 
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
	
	@Test(enabled = false, priority=5) 
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
		
	
	@Test(priority=6 , enabled=true)
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
	
	@Test(priority=7 , enabled=true)
	public void popularArticlesCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		element.getAcceptCookies().click();
		element1.getArticlesIcon().click();
		Assert.assertEquals(element1.getPopularArticles().isDisplayed(), true);
		
	}
	
	@Test(priority=8 , enabled=true)
	public void popularTopicsCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		element.getAcceptCookies().click();
		element1.getArticlesIcon().click();
		Assert.assertEquals(element1.getPopularTopics().isDisplayed(), true);
		
	}
	
	@Test(priority=9 , enabled=true)
	public void popularBlogsCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		element.getAcceptCookies().click();
		element1.getArticlesIcon().click();
		Assert.assertEquals(element1.getPopularBlogs().isDisplayed(), true);
		
	}
	@Test(priority=10 , enabled=true)
	public void AppstoreImageCheck() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		element.getAcceptCookies().click();
		Assert.assertEquals(element1.getAppstoreImage().isDisplayed(), true);
	
	}
	
@Test(priority=11 , enabled=true)
public void KbarHeader() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	ProdElements element = new ProdElements(driver);
	Assert.assertEquals(element.getKbar().isDisplayed(), true);
	
}

@Test(priority=12 , enabled=true)
public void Guestuser() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));}
	catch(WebDriverException e) {}
	CreateAlertElements element = new CreateAlertElements(driver);
	ProdElements element1 = new ProdElements(driver);
	element.getAcceptCookies().click();
	Actions action = new Actions(driver);
	action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
	element.getSearchButton().click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='full-page-loader-comp text-center']"))));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 1500)");
	Assert.assertEquals(element1.getGuestUserPopup().isDisplayed(), true);

}

@Test(priority=13 , enabled=true)
public void facebook() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    element.getAcceptCookies().click();
    
	try {js.executeAsyncScript("arguments[0].click();",element1.getFacebookIcon());}
	catch (Exception e) {}
		
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/rewardflightfinder/");
}



@Test(priority=14 , enabled=true)
public void Twitter() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    element.getAcceptCookies().click();
    try {js.executeAsyncScript("arguments[0].click();",element1.getTwitterIcon());}
	catch (Exception e) {}
	
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


@Test(priority=15 , enabled=true)
public void Linkedin() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
	element.getAcceptCookies().click();
    	
	try {js.executeAsyncScript("arguments[0].click();",element1.getlinkedInIcon());}
	catch (Exception e) {}
	
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

@Test(priority=16 , enabled=true)
public void Instagram() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    element.getAcceptCookies().click();
    
	try {js.executeAsyncScript("arguments[0].click();",element1.getInstagramIcon());}
	catch (Exception e) {}
	
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	
	Assert.assertEquals(driver.getCurrentUrl(), "https://www.instagram.com/rewardflightfinder/");
}



@Test(priority=17 , enabled=true)
public void GooglePlay() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    element.getAcceptCookies().click();
    
	try {js.executeAsyncScript("arguments[0].click();",element1.getPlaystoreImage());}
	catch (Exception e) {}
	
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
	Assert.assertEquals(driver.getCurrentUrl(), "https://play.google.com/store/apps/details?id=com.rewardflightfinder.app.android");
}


@Test(priority=18 , enabled=true)
public void Applestore() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    element.getAcceptCookies().click();
    try {js.executeAsyncScript("arguments[0].click();",element1.getApplestoreImage());}
	catch (Exception e) {}
	
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		}
		else {break;}
	}
		Assert.assertEquals(driver.getCurrentUrl(), "https://apps.apple.com/us/app/reward-flight-finder/id1467629555");
	}
	

}
	
	
