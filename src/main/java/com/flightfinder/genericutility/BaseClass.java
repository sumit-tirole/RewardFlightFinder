package com.flightfinder.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public void preConditions() throws Throwable{
//		ScreenRecorderUtil.startRecord("preConditions");
		String browserName = fileUtils.readFromPropertyFile("browser");
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver(options);
			}
		
		else if(browserName.equals("edge")) {driver=new EdgeDriver();}
		else if(browserName.equals("firefox")) {driver=new FirefoxDriver();}
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
}
