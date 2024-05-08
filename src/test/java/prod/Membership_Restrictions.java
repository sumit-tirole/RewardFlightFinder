package prod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flightfinder.genericutility.BaseClass;
import com.flightfinder.genericutility.FileUtility;
import com.flightfinder.pomrepo.CreateAlertElements;

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
		element.getAcceptCookies().click();
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
		element.getAcceptCookies().click();
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
	
	
}
	
	
