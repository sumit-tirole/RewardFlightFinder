package com.flightfinder.genericutility;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.Duration;

import listeners.ExtentReportListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	FileUtility fileUtils = new FileUtility();
		
	public static WebDriver getDriver() {
		return driver;
	}

	// Executing before test
	@BeforeMethod
	public void preConditions() throws Throwable {
//		ScreenRecorderUtil.startRecord("preConditions");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int screenWidth = (int) screenSize.getWidth();
	    int screenHeight = (int) screenSize.getHeight();
	    String windowSize = screenWidth + "," + screenHeight;
	    
		String browserName = fileUtils.readFromPropertyFile("browser");
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=" + windowSize);
//	        System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		
		else if(browserName.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--lang=en-US");
			options.addArguments("--headless");
			options.addArguments("--window-size=" + windowSize);
			System.out.println("Running on Edge");
			driver=new EdgeDriver(options);
			}
		else if(browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--lang=en-US");
			options.addArguments("--headless");
			options.addArguments("--window-size=" + windowSize);
			driver=new FirefoxDriver(options);
			}
		else { System.out.println("BrowserName should be chrome, edge, firefox(lowercase letters) "); 
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(5));
			    
		}
		
	//Executing after test
	@AfterMethod
	public void postConditions() throws Exception {
//		ScreenRecorderUtil.stopRecord();
		driver.close();
		driver.quit();	
		Thread.sleep(1000);	}
	
	
	public void waitForLoader() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='full-page-loader-comp text-center']")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='full-page-loader-comp text-center']")));
	}
}
