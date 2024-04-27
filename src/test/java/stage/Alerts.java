package stage;

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



public class Alerts extends BaseClass {
	FileUtility fileUtils = new FileUtility();
	public static String outboundDate;
	public Logger log = LogManager.getLogger(Alerts.class);
	
	
	
	@Test(priority=1, enabled = true)
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
		Thread.sleep(2000);
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
	
	
	@Test(priority=2, enabled = true)
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
	
	@Test(priority=3, enabled = true)
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
		
}
	
	
