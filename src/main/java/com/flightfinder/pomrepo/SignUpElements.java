package com.flightfinder.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpElements {

	public static WebDriver driver;
	
	
	public SignUpElements(WebDriver driver) {
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
	
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signUpButton;
	
	
	public WebElement getSignUpButton() {
		synchronised(By.xpath("//button[text()='Sign Up']"),signUpButton);
		return signUpButton;
	}
	
	@FindBy(xpath="//button[text()='Subscribe']")
	WebElement bronzeSubscribeButton;


	public WebElement getBronzeSubscribeButton() {
		synchronised(By.xpath("//button[text()='Subscribe']"),bronzeSubscribeButton);
		return bronzeSubscribeButton;
	}
	
	@FindBy(xpath="//div[@class='pricing-gold-member pricing-silver-member']//button[text()='Start Your 7 Day Free Trial']")
	WebElement silverSubscribeButton;
		
	public WebElement getSilverSubscribeButton() {
		synchronised(By.xpath("//div[@class='pricing-gold-member pricing-silver-member']//button[text()='Start Your 7 Day Free Trial']"),silverSubscribeButton);
		return silverSubscribeButton;
	}
	
	@FindBy(xpath="//div[@class='pricing-gold-member gold-bg-img']//button[text()='Start Your 7 Day Free Trial']")
	WebElement goldSubscribeButton;

	public WebElement getGoldSubscribeButton() {
		synchronised(By.xpath("//div[@class='pricing-gold-member gold-bg-img']//button[text()='Start Your 7 Day Free Trial']"),goldSubscribeButton);
		return goldSubscribeButton;
	}

	@FindBy(xpath="//input[@name='email']")
	WebElement emailTextField;


	public WebElement getEmailTextField() {
		synchronised(By.xpath("//input[@name='email']"),emailTextField);
		return emailTextField;
	}
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueButton;


	public WebElement getContinueButton() {
		synchronised(By.xpath("//button[text()='Continue']"),continueButton);
		return continueButton;
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextField;


	public WebElement getPasswordTextField() {
		synchronised(By.xpath("//input[@name='password']"),passwordTextField);
		return passwordTextField;
	}
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement confirmPasswordTextField;
	
	public WebElement getConfirmPasswordTextField() {
		synchronised(By.xpath("//input[@name='confirmPassword']"),confirmPasswordTextField);
		return confirmPasswordTextField;
	}
	
	@FindBy(xpath="//button[text()='Set Password']")
	WebElement setPassword;


	public WebElement getSetPassword() {
		synchronised(By.xpath("//button[text()='Set Password']"),setPassword);
		return setPassword;
	}
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstNameTextField;
	
	public WebElement getFirstNameTextField() {
		synchronised(By.xpath("//input[@name='firstName']"),firstNameTextField);
		return firstNameTextField;
	}
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastNameTextField;
	
	public WebElement getLastNameTextField() {
		synchronised(By.xpath("//input[@name='lastName']"),lastNameTextField);
		return lastNameTextField;
	}
	
	@FindBy(xpath="//button[text()='Sign up']")
	WebElement signUpButton2;
	
	public WebElement getSignUpButton2() {
		synchronised(By.xpath("//button[text()='Sign up']"),signUpButton2);
		return signUpButton2;
	}
	
	@FindBy(xpath="//p[@class='thankyou-page__text']")
	WebElement confirmSignUp;


	public WebElement getConfirmSignUp() {
		synchronised(By.xpath("//p[@class='thankyou-page__text']"),confirmSignUp);
		return confirmSignUp;
	}
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueAfterSignUpButton;


	public WebElement getContinueAfterSignUpButton() {
		synchronised(By.xpath("//button[text()='Continue']"),continueAfterSignUpButton);
		return continueAfterSignUpButton;
	}
	
	@FindBy(xpath="//*[@id=\"cb-body\"]/div/div[2]/div[2]/button")
	WebElement proceedToCheckoutButton;

	public WebElement getProceedToCheckoutButton() {
		synchronised(By.xpath("//*[@id=\"cb-body\"]/div/div[2]/div[2]/button"),proceedToCheckoutButton);
		return proceedToCheckoutButton;
	}
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement billingName;
	
	public WebElement getBillingName() {
		synchronised(By.xpath("//input[@id='first_name']"),billingName);
		return billingName;
	}
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement billingLastName;
	
	public WebElement getBillingLastName() {
		synchronised(By.xpath("//input[@id='last_name']"),billingLastName);
		return billingLastName;
	}
	
	@FindBy(xpath="//input[@id='zip']")
	WebElement zipCode;
	
	public WebElement getZipCode() {
		synchronised(By.xpath("//input[@id='zip']"),zipCode);
		return zipCode;
	}
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextButton;
	
	public WebElement getNextButton() {
		synchronised(By.xpath("//span[contains(text(),'Next')]"),nextButton);
		return nextButton;
	}
	
	@FindBy(xpath="//input[@name='cc-number']")
	WebElement cardNumberTextField;

	public WebElement getCardNumberTextField() {
		synchronised(By.xpath("//input[@name='cc-number']"),cardNumberTextField);
		return cardNumberTextField;
	}
	
	@FindBy(xpath="//iframe[@title='Checkout Page']")
	WebElement frameElement;
		
	public WebElement getFrameElement() {
		synchronised(By.xpath("//iframe[@title='Checkout Page']"),frameElement);
		return frameElement;
	}
	
	@FindBy(xpath="//input[@id='exp_month']")
	WebElement expiryTextField;

	public WebElement getExpiryTextField() {
		synchronised(By.xpath("//input[@id='exp_month']"),expiryTextField);
		return expiryTextField;
	}
	
	@FindBy(xpath="//input[@id='cvv']")
	WebElement cvvTextField;

	public WebElement getCvvTextField() {
		synchronised(By.xpath("//input[@id='cvv']"),cvvTextField);
		return cvvTextField;
	}
	
	@FindBy(xpath="//button[@class='cb-button cb-button__primary']")
	WebElement nextButton2;

	public WebElement getNextButton2() {
		synchronised(By.xpath("//button[@class='cb-button cb-button__primary']"),nextButton2);
		return nextButton2;
	}
	
	@FindBy(xpath="//button[@class='cb-button cb-button__primary']")
	WebElement subscribeButton;

	public WebElement getSubscribeButton() {
		synchronised(By.xpath("//button[@class='cb-button cb-button__primary']"),subscribeButton);
		return subscribeButton;
	}
	
	@FindBy(xpath="//p[@class='thankyou-page__text mb-0']")
	WebElement confirmSilverSignup;

	
	public WebElement getConfirmSilverSignup() {
		synchronised(By.xpath("//p[@class='thankyou-page__text mb-0']"),confirmSilverSignup);
		return confirmSilverSignup;
	}
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueSilverSignupButton;


	public WebElement getContinueSilverSignupButton() {
		synchronised(By.xpath("//button[text()='Continue']"),continueSilverSignupButton);
		return continueSilverSignupButton;
	}
	
	
	
}
