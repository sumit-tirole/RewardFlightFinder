package com.flightfinder.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLogin {

public static WebDriver driver;	
	
	
	public FacebookLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element)  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		try {
		Thread.sleep(1000); }
		catch (InterruptedException e) {
		e.printStackTrace();	
		}
		}
	
	@FindBy(xpath="//button[@class='fb-login-btn metro']")
	WebElement fbSignInButton;
	
	
	public WebElement getFbSignInButton() {
		synchronised(By.xpath("//button[@class='fb-login-btn metro']"),fbSignInButton);
		return fbSignInButton;

	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement fbEmailTextField;


	public WebElement getFbEmailTextField() {
		synchronised(By.xpath("//input[@name='email']"),fbEmailTextField);
		return fbEmailTextField;
	}
	
		
	@FindBy(xpath="//input[@name='pass']")
	WebElement fbPasswordTextField;


	public WebElement getFbPasswordTextField() {
		synchronised(By.xpath("//input[@name='pass']"),fbPasswordTextField);
		return fbPasswordTextField;
	}
	
	@FindBy(xpath="//input[@name='login']")
	WebElement fbLoginButton;


	public WebElement getFbLoginButton() {
		synchronised(By.xpath("//input[@name='login']"),fbLoginButton);
		return fbLoginButton;
	}
	
	
}
