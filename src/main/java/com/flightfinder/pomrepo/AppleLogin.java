package com.flightfinder.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppleLogin {

public static WebDriver driver;	
	
	
	public AppleLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element)  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		try {
		Thread.sleep(300); }
		catch (InterruptedException e) {
		e.printStackTrace();	
		}
		}
	
	@FindBy(xpath="//button[@class='btn w-100 apple-log-btn ']")
	WebElement appleSignInButton;
		
	public WebElement getAppleSignInButton() {
		synchronised(By.xpath("//button[@class='btn w-100 apple-log-btn ']"),appleSignInButton);
		return appleSignInButton;
	}
	
	@FindBy(xpath="//input[@id='account_name_text_field']")
	WebElement appleEmailField;

	public WebElement getAppleEmailField() {
		synchronised(By.xpath("//input[@id='account_name_text_field']"),appleEmailField);
		return appleEmailField;
	}
	
	@FindBy(xpath="//button[@id='continue-password']")
	WebElement continueWithPasswordButton;

	public WebElement getContinueWithPasswordButton() {
		synchronised(By.xpath("//button[@id='continue-password']"),continueWithPasswordButton);
		return continueWithPasswordButton;
	}
	
	@FindBy(xpath="//input[@id='password_text_field']")
	WebElement applePasswordField;

	public WebElement getApplePasswordField() {
		synchronised(By.xpath("//input[@id='password_text_field']"),applePasswordField);
		return applePasswordField;

		
}
}
