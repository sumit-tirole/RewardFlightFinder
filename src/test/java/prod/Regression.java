package prod;

import java.time.Duration;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
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
import com.flightfinder.pomrepo.MapPage;
import com.flightfinder.pomrepo.ProdElements;
import com.flightfinder.pomrepo.SignUpElements;
import listeners.ExtentReportListener;
import listeners.ScreenshotUtility;



public class Regression extends BaseClass {
	FileUtility fileUtils = new FileUtility();
	public static String outboundDate;
	public Logger log = LogManager.getLogger(Regression.class);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	
		
	@Test(priority=1, enabled = true, description = "Login using invalid credentials")
	public void login_Invalid_Credentials_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("email"));
		element.getPasswordTextField().sendKeys("ABC@123");
		element.getSignInButton().click();
		String errorMsg = element.getErrorMsg().getText();
		Assert.assertEquals(errorMsg, "Invalid email or password.");
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Invalid Login validation");
	}
	
	@Test(priority=2, enabled = true, description = "Login using valid credentials")
	public void login_Valid_Credentials_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodemail"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodpass"));
		element.getSignInButton().click();
		for (int i = 0; i < 3; i++) {
		    try {element.getAccountButton().click();
		        break;} 
		    catch (StaleElementReferenceException e) {}}
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Valid Login validation");
		element.getLogoutButton().click();
		
	}
		
	@Test(priority=3, enabled = false, description = "Login using gmail on prod environment")
	public void login_With_Google_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		GoogleLogin element1 = new GoogleLogin(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
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
		element1.getPasswordNext().click();
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equals("https://rewardflightfinder.com/")) {
			break;
			}
		}
		for (int i = 0; i < 3; i++) {
		    try {element.getAccountButton().click();
		        break;} 
		    catch (StaleElementReferenceException e) {}}
		element.getLogoutButton().click();
		
	}
	
	@Test(priority=4, enabled = false, description = "Alert date range Restrictions for Silver user") 
	public void login_With_Facebook_Prod() throws Throwable{
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		FacebookLogin element1 = new FacebookLogin(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
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
		for (int i = 0; i < 3; i++) {
		    try {element.getAccountButton().click();
		        break;} 
		    catch (StaleElementReferenceException e) {}}
		
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Facebook Login validation");
		element.getLogoutButton().click();
		
	}
	
	@Test(enabled = false, priority=5, description = "Login with apple id on prod environment") 
	public void login_With_Apple_Prod() throws Throwable{
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		AppleLogin element1 = new AppleLogin(driver);
		
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
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
		
	
	@Test(priority=6 , enabled=true, description = "Signup as a Bronze user on prod environment")
	public void signup_Bronze_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("bronzeurl"));}
		catch(WebDriverException e) {}
		SignUpElements element = new SignUpElements(driver);
		CreateAlertElements element1 = new CreateAlertElements(driver);
		try{
            element1.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element1.getAcceptCookies().click();
        }
		String email = "TestBronzeProd"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com";
		element.getEmailTextField().sendKeys(email);
        element.getContinueButton().click();
        element.getPasswordTextField().sendKeys("Test@123");
        element.getConfirmPasswordTextField().sendKeys("Test@123");
        element.getSetPassword().click();
        element.getFirstNameTextField().sendKeys("Prod");
        element.getLastNameTextField().sendKeys("Bronze");
        element.getSignUpButton2().click();
        System.out.println(element.getConfirmSignUp().getText());  //Printing successfull signup message to console
        String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
    	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Bronze signup validation");
        element.getContinueAfterSignUpButton().click();
        ExtentReportListener.logMessage("Email: "+email);
	}
	
	@Test(priority=7 , enabled=true, description = "Check visibility of popular articles on prod environment")
	public void popularArticles_Check_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element1.getArticlesIcon().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Assert.assertEquals(element1.getPopularArticles().isDisplayed(), true);
		jse.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//picture[@class='d-b'])[5]")))); 
			
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for popular articles validation");
	}
	
	@Test(priority=8 , enabled=true, description = "Check visibility of popular topics on prod environment")
	public void popularTopics_Check_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element1.getArticlesIcon().click();
		Assert.assertEquals(element1.getPopularTopics().isDisplayed(), true);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1050)");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//picture[@class='d-b'])[5]"))));
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for popular topics validation");
	}
	
	@Test(priority=9 , enabled=true, description = "Check visibility of popular blogs on prod environment")
	public void popularBlogs_Check_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element1.getArticlesIcon().click();
		Assert.assertEquals(element1.getPopularBlogs().isDisplayed(), true);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//picture[@class='blog-cardimg'])[1]"))));
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for popular blogs validation");
	}
	
	@Test(priority=10 , enabled=true, description = "Check visibility of Appstore logo")
	public void AppstoreImage_Check_Prod() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));
		}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		ProdElements element1 = new ProdElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		((JavascriptExecutor) driver).executeScript
		("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });", element1.getAppstoreImage());
		Assert.assertEquals(element1.getAppstoreImage().isDisplayed(), true);
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Appstore image validation");
	
	}
	
@Test(priority=11 , enabled=true, description = "Check visibility of Kbar")
public void KbarHeaderProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	ProdElements element = new ProdElements(driver);
	Assert.assertEquals(element.getKbar().isDisplayed(), true);
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Kbar header validation");
}

@Test(priority=12 , enabled=true, description = "Check visibility signup banner to guest user on Calender page")
public void GuestuserProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));}
	catch(WebDriverException e) {}
	CreateAlertElements element = new CreateAlertElements(driver);
	ProdElements element1 = new ProdElements(driver);
	try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
	Actions action = new Actions(driver);
	action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
	element.getSearchButton().click();
	try {
	    waitForLoader();
	} catch (TimeoutException e) {
	    
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 1000)");
	Thread.sleep(3000);
	String popupActualText = element1.getGuestUserPopup().getText();
	String popupExpectedText = "Create a free account to see a full year ahead";
	Assert.assertEquals(popupActualText, popupExpectedText);
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for guest user restrictions");
}

@Test(priority=13 , enabled=true, description = "Check facebook link redirection")
public void facebookProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
    
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
	element1.getFbCloseButton().click();
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for facebook redirection validation");
}



@Test(priority=14 , enabled=true, description = "Check twitter link redirection")
public void TwitterProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
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
	Assert.assertTrue(twitterurl.contains("https://x.com"), "url does not contain https://x.com");
	Assert.assertTrue(twitterurl.contains("rewardflightfdr"), "url does not contain rewardflightfdr");
	Thread.sleep(3000);
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for twitter redirection validation");
}


@Test(priority=15 , enabled=true, description = "Check linkedin link redirection")
public void LinkedinProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
    	
	try {js.executeAsyncScript("arguments[0].click();",element1.getlinkedInIcon());}
	catch (Exception e) {}
	
	Set <String> handles = driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		Thread.sleep(500);
		if(driver.getTitle().equals("Easily Find Reward Flight Availability: Redeem British Airways Avios Points")) {
		} 
		else {break;}
	}
	String linkedinurl = driver.getCurrentUrl();
	System.out.println(linkedinurl);
	Assert.assertEquals(linkedinurl, "https://www.linkedin.com/company/reward-flight-finder/");
	element1.getLinkedinCloseButton().click();
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for linkedin redirection validation");
}

@Test(priority=16 , enabled=true, description = "Check Instagram link redirection")
public void InstagramProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
    
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
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for instagram redirection validation");
}



@Test(priority=17 , enabled=true, description = "Check Google play link redirection")
public void GooglePlayProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
    
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
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Playstore redirection validation");
}


@Test(priority=18 , enabled=true, description = "Check Apple store link redirection")
public void ApplestoreProd() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	JavascriptExecutor js = (JavascriptExecutor) driver;
    CreateAlertElements element = new CreateAlertElements(driver);
    ProdElements element1 = new ProdElements(driver);
    try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
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
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Apple store redirection validation");
	}
	
	
@Test(priority=19 , enabled=true, description = "Check Map page destinations")
public void Check_Map_Page_Destinations() throws Throwable {
	try {driver.get(fileUtils.readFromPropertyFile("url"));
	}
	catch(WebDriverException e) {}
	CreateAlertElements element = new CreateAlertElements(driver);
	MapPage element1 = new MapPage(driver);
	try{
        element.getAcceptCookies().click();}
    catch(WebDriverException e) {
        element.getAcceptCookies().click();
    }
	element.getSignInLink().click();
	element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodemail"));
	element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodpass"));
	element.getSignInButton().click();
	
	for (int i = 0; i < 3; i++) {
	    try {element1.getWorldMapButton().click();
	        break;} 
	    catch (StaleElementReferenceException e) {}}
	
	try {
	    waitForLoader();
	} catch (TimeoutException e) {
	    
	}
	Actions action = new Actions(driver);
	Thread.sleep(1000);
	action.click(element1.getWhereFromField()).pause(1000).sendKeys("london").pause(1000).sendKeys(Keys.ENTER).build().perform();
	element1.getDateField().click();
	element1.getNextMonth().click();
	element1.getStartDate().click();
	element1.getEndDate().click();
	element1.getStartDate().click();
	element1.getEndDate().click();
	element1.getSetDatesButton().click();
	element1.getSearchButton().click();
	int destinationNumber = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 101);
	element1.getSelectDestination(destinationNumber).click();
	Thread.sleep(5000);
	String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
	ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Map page zoom in validation");
	element.getAccountButton().click();
	element.getLogoutButton().click();
	}
	

}
	
	
