package prod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flightfinder.genericutility.BaseClass;
import com.flightfinder.genericutility.FileUtility;
import com.flightfinder.pomrepo.CreateAlertElements;
import com.flightfinder.pomrepo.MapPage;

import listeners.ExtentReportListener;
import listeners.ScreenshotUtility;



public class Membership_Restrictions extends BaseClass {
	FileUtility fileUtils = new FileUtility();
	public static String outboundDate;
	public Logger log = LogManager.getLogger(Membership_Restrictions.class);
	
	
	
	@Test(priority=1, enabled = true)
	public void date_range_restrictions_bronze() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodbronzeemail"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodbronzepass"));
		element.getSignInButton().click();
		Actions action = new Actions(driver);
		action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
		element.getSearchButton().click();
		try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
		try {
			element.getBronzeUpgradePopup().click(); }
			catch (NoSuchElementException e) { }
		
		element.getCreateAlertButton().click();
		element.getDepartStartDate().click();
		element.getNextMonth().click();
		element.getStartDateBronze().click();
		element.getEndDateBronze().click();
		element.getreturnStartDate().click();
		element.getNextMonth().click();
		element.getStartDateBronze().click();
		element.getEndDateBronze().click();
		String errorText = "Maximum date range allowed is 20 days per leg for Bronze members";
		Assert.assertTrue(element.getActiveAlertText().getText().contains(errorText));
		WebElement createAlertButton = driver.findElement(By.xpath("//div[@class='popup-footer']/button[text()='Create Alert']"));
		Assert.assertEquals(createAlertButton.isEnabled(),false);
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Alert created validation");
		element.getCloseButton2().click();
		element.getAccountButton().click();
		element.getLogoutButton().click();
		}	
		
	@Test(priority=2, enabled = true)
	public void date_range_restrictions_silver() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodsilveremail"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodsilverpass"));
		element.getSignInButton().click();
		Actions action = new Actions(driver);
		action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
		element.getSearchButton().click();
		try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
				
		element.getCreateAlertButton().click();
		element.getDepartStartDate().click();
		element.getNextMonth().click();
		element.getStartDateSilver().click();
		element.getNextMonth().click();
		element.getEndDateSilver().click();
		element.getreturnStartDate().click();
		element.getNextMonth().click();
		element.getStartDateSilver().click();
		element.getNextMonth().click();
		element.getEndDateSilver().click();
		String errorText = "Maximum date range allowed is 45 days per leg for Silver members.";
		Assert.assertTrue(element.getActiveAlertText().getText().contains(errorText));
		WebElement createAlertButton = driver.findElement(By.xpath("//div[@class='popup-footer']/button[text()='Create Alert']"));
		Assert.assertEquals(createAlertButton.isEnabled(),false);
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Alert created validation");
		element.getCloseButton2().click();
		element.getAccountButton().click();
		element.getLogoutButton().click();
		}
		
	@Test(priority=20 , enabled=true)
	public void Check_bronze_mapPage_restrictions() throws Throwable {
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
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodbronzeemail"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodbronzepass"));
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
		action.click(element1.getWhereFromField()).pause(1000).sendKeys("london" , Keys.ENTER).build().perform();
		element1.getDateField().click();
		element1.getNextMonth().click();
		element1.getStartDate().click();
		element1.getEndDate().click();
		element1.getStartDate().click();
		element1.getEndDate().click();
		element1.getSetDatesButton().click();
		element1.getSearchButton().click();
		Assert.assertEquals(element1.getUpgradeMembershipPopup().getText(),"You need to be a Silver or Gold member to use the world map search");
		Assert.assertEquals(element1.getMembershipsButton().isDisplayed(),true);
		System.out.println(element1.getUpgradeMembershipPopup().getText());
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		element1.getCloseButton().click();
		element.getAccountButton().click();
		element.getLogoutButton().click();
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for Upgrade membership validation");
	}
		
	@Test(priority=21, enabled = true)
	public void check_one_alert_restriction_bronze() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodbronzeemail"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodbronzepass"));
		element.getSignInButton().click();
		Actions action = new Actions(driver);
		action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
		element.getSearchButton().click();
			
		try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
		
		try {
		element.getBronzeUpgradePopup().click(); }
		catch (NoSuchElementException e) { }
		
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
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for upgrade membership validation");
		String actualPopupText = element.getBronzeUpgradePopup2().getText();
		String expectedPopText = "You can only have 1 active alert at once. Please either delete the existing active alert or upgrade your membership";
		Assert.assertEquals(actualPopupText, expectedPopText);
		element.getUpgradeButton().click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://rewardflightfinder.com/pricing");
		try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
		element.getAccountButton().click();
		element.getLogoutButton().click();
		}
		
	@Test(priority=22, enabled = true)
	public void check_five_alert_restriction_silver() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("url"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		try{
            element.getAcceptCookies().click();}
        catch(WebDriverException e) {
            element.getAcceptCookies().click();
        }
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys(fileUtils.readFromPropertyFile("prodsilveremail"));
		element.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodsilverpass"));
		element.getSignInButton().click();
		Actions action = new Actions(driver);
		action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
		element.getSearchButton().click();
		try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
			
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
		String screenshotPath1 = ScreenshotUtility.captureScreenshot(driver);
		ExtentReportListener.screenshot(screenshotPath1,"Screenshot for upgrade membership validation");
		String actualPopupText = element.getBronzeUpgradePopup2().getText();
		System.out.println(actualPopupText);
		String expectedPopText = "You can only have 5 active alerts at once. Please either delete one of your other active alerts, or upgrade your membership";
		Assert.assertEquals(actualPopupText, expectedPopText);
		element.getUpgradeButton().click();
		try {
		    waitForLoader();
		} catch (TimeoutException e) {
		    
		}
		Assert.assertEquals(driver.getCurrentUrl(),"https://rewardflightfinder.com/pricing");
		element.getAccountButton().click();
		element.getLogoutButton().click();
		}
	
}
	
	
