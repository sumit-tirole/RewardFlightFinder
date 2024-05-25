package com.flightfinder.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAlertElements {
	
public static WebDriver driver;	
	
	
	public EditAlertElements(WebDriver driver) {
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
	
	
	@FindBy(xpath="//button[@class='addPas ']")
	WebElement addPassengersButton;


	public WebElement getAddPassengersButton() {
		synchronised(By.xpath("//button[@class='addPas ']"),addPassengersButton);
		return addPassengersButton;
	}
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;

	public WebElement getSaveButton() {
		synchronised(By.xpath("//button[text()='Save']"),saveButton);
		return saveButton;
	}
	
	@FindBy(xpath="//div[@class='Toastify__toast-body']")
	WebElement confirmEditAlert;
		
	public WebElement getConfirmEditAlert() {
		synchronised(By.xpath("//div[@class='Toastify__toast-body']"),confirmEditAlert);
		return confirmEditAlert;
	}
	
	
}
