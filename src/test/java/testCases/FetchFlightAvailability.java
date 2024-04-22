package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.flightfinder.genericutility.BaseClass;
import com.flightfinder.genericutility.FileUtility;
import com.flightfinder.pomrepo.CreateAlertElements;

public class FetchFlightAvailability extends BaseClass {

	FileUtility fileUtils = new FileUtility();
	
	@Test(priority=1, enabled = true)
	public void loginValidCredentials() throws Throwable {
		try {driver.get(fileUtils.readFromPropertyFile("stageurl"));}
		catch(WebDriverException e) {}
		CreateAlertElements element = new CreateAlertElements(driver);
		element.getAcceptCookies().click();
		element.getSignInLink().click();
		element.getEmailTextField().sendKeys("fowler20@eqntfrue.com");
		element.getPasswordTextField().sendKeys("Test@123");
		element.getSignInButton().click();
		Actions action = new Actions(driver);
		action.click(element.getWhereToField()).pause(1000).sendKeys("nyc" , Keys.ENTER).build().perform();
		element.getSearchButton().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		checkMonths("May",31);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		checkMonths("Jun",30);
		jse.executeScript("window.scrollBy(0,300)");
		checkMonths("Jul",31);
		
		
		
//		element.getAccountButton().click();
//		element.getLogoutButton().click();
		
	}
	
	public void checkMonths(String Month,int days) throws Throwable{
		for(int i=1;i<=days;i++)
		{	
		if(i<=9) {	
		Thread.sleep(2000);
		WebElement date = driver.findElement(By.xpath("(//div[contains(@aria-label,'"+Month+" 0"+i+" 2024')])[1]"));
		System.out.println("(//div[contains(@aria-label,'May 0"+i+" 2024')])[1]");
		date.click();
		Thread.sleep(1000);
		WebElement close = driver.findElement(By.xpath("//*[local-name()='svg' and @class='cst-popup__close ']"));
		close.click();
		}
		else {
			Thread.sleep(2000);
			WebElement date = driver.findElement(By.xpath("(//div[contains(@aria-label,'"+Month+" "+i+" 2024')])[1]"));
			date.click();
			
			Thread.sleep(1000);
			WebElement close = driver.findElement(By.xpath("//*[local-name()='svg' and @class='cst-popup__close ']"));
			close.click();
		}
		}
	}
	
}
