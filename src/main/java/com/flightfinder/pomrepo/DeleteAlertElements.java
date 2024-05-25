package com.flightfinder.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DeleteAlertElements{
	
public static WebDriver driver;	
			
	public DeleteAlertElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element)  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		try {
		Thread.sleep(10); }
		catch (InterruptedException e) {
		e.printStackTrace();	
		}
		}
	
	
	@FindBy(xpath="//div[@data-for='alerts']")
	WebElement alertButton;


	public WebElement getAlertButton() {
		synchronised(By.xpath("//div[@data-for='alerts']"),alertButton);
		return alertButton;
	}
	
	
	public WebElement getEditAlertButton(String outboundDate) {
		WebElement editAlertButton = driver.findElement(By.xpath("//span[text()='"+outboundDate+"'][1]/ancestor::div[@class='alert-box droppable']//p[text()='Edit Alert']"));
		synchronised(By.xpath("//span[text()='"+outboundDate+"'][1]/ancestor::div[@class='alert-box droppable']//p[text()='Edit Alert']"),editAlertButton);
		System.out.println(outboundDate);
		return editAlertButton;
	}
	
	@FindBy(xpath="//button[text()='Delete Alert']")
	WebElement deleteButton;


	public WebElement getDeleteButton() {
		synchronised(By.xpath("//button[text()='Delete Alert']"),deleteButton);
		return deleteButton;
	}
	

	
	
}
