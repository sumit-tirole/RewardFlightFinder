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

public class MapPage {

public static WebDriver driver;	
	
	
	public MapPage(WebDriver driver) {
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
	
	@FindBy(xpath="//div[@data-for='map-page']")
	WebElement worldMapButton;
		
	public WebElement getWorldMapButton() {
		synchronised(By.xpath("//div[@data-for='map-page']"),worldMapButton);
		return worldMapButton;
	}
	
	@FindBy(xpath="//div[text()='Where from?']")
	WebElement whereFromField;
	
	public WebElement getWhereFromField() {
		synchronised(By.xpath("//div[text()='Where from?']"),worldMapButton);
		return whereFromField;
	}
	
	@FindBy(xpath="//input[@id='startDateDep']")
	WebElement dateField;
	
	public WebElement getDateField() {
		synchronised(By.xpath("//input[@id='startDateDep']"), dateField);
		return dateField;
	}
	
	@FindBy(xpath="//div[@aria-label='Move forward to switch to the next month.']")
	WebElement nextMonth;
	
	public WebElement getNextMonth() {
		synchronised(By.xpath("//div[@aria-label='Move forward to switch to the next month.']"),nextMonth);
		return nextMonth;
	}
	
	@FindBy(xpath="(//div[text()='15' and @class='CalendarDay__Date'])[2]")
	WebElement startDate;
	
	public WebElement getStartDate() {
		synchronised(By.xpath("(//div[text()='15' and @class='CalendarDay__Date'])[2]"),startDate);
		return startDate;
	}
	
	@FindBy(xpath="(//div[text()='22' and @class='CalendarDay__Date'])[2]")
	WebElement endDate;
	
	public WebElement getEndDate() {
		synchronised(By.xpath("(//div[text()='22' and @class='CalendarDay__Date'])[2]"),endDate);
		return endDate;
	}
	
	@FindBy(xpath="//button[text()='Set Dates']")
	WebElement setDatesButton;
	
	public WebElement getSetDatesButton() {
		synchronised(By.xpath("//button[text()='Set Dates']"),setDatesButton);
		return setDatesButton;
	}
	
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchButton;
	
	public WebElement getSearchButton() {
		synchronised(By.xpath("//button[text()='Search']"),searchButton);
		return searchButton;
		
	}
		
	public WebElement getSelectDestination(int destinationNumber) {
		WebElement destination = driver.findElement(By.xpath("(//div[@class='destination-country-wrap'])["+destinationNumber+"]"));
		synchronised(By.xpath("(//div[@class='destination-country-wrap'])["+destinationNumber+"]"),destination);
		System.out.println(destinationNumber);
		return destination;
	} 
	
	@FindBy(xpath="//p[@class='cst-popup__text']")
	WebElement upgradeMembershipPopup;
	
	public WebElement getUpgradeMembershipPopup() {
		synchronised(By.xpath("//p[@class='cst-popup__text']"),upgradeMembershipPopup);
		return upgradeMembershipPopup;
	}

	@FindBy(xpath="//button[text()='Memberships']")
	WebElement membershipsButton;
	
	public WebElement getMembershipsButton() {
		synchronised(By.xpath("//button[text()='Memberships']"),membershipsButton);
		return membershipsButton;
	}
	
	@FindBy(xpath="//*[@class='cst-popup__close']")
	WebElement closeButton;
	
	public WebElement getCloseButton() {
		synchronised(By.xpath("//*[@class='cst-popup__close']"),closeButton);
		return closeButton;
	}
	
	
}

