package com.flightfinder.pomrepo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdElements {

	public static WebDriver driver;
	
	
	public ProdElements(WebDriver driver) {
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
	
	
	@FindBy(xpath="//*[@class=\"kbar-header\"]")
	WebElement kbar;

	public WebElement getKbar() {
		synchronised(By.xpath("//*[@class=\"kbar-header\"]"),kbar);
		return kbar;
	}
	
	@FindBy(xpath="(//*[local-name()='svg'])[3]")
	WebElement articlesIcon;
		
	
	public WebElement getArticlesIcon() {
		synchronised(By.xpath("(//*[local-name()='svg'])[3]"),articlesIcon);
		return articlesIcon;
	}

	@FindBy(xpath="//div[@class='popular_article_inner cursor-pointer parentNode']")
	WebElement popularArticles;
	
	public WebElement getPopularArticles() {
		synchronised(By.xpath("//div[@class='popular_article_inner cursor-pointer parentNode']"),popularArticles);
		return popularArticles;
	}
	
	@FindBy(xpath="//div[@class='popular_topics-tags']")
	WebElement popularTopics;

	
	public WebElement getPopularTopics() {
		synchronised(By.xpath("//div[@class='popular_topics-tags']"),popularTopics);
		return popularTopics;
	}
	
	@FindBy(xpath="(//*[@class='blogCard context-menu'])[1]")
	WebElement popularBlogs;
	
	public WebElement getPopularBlogs() {
		synchronised(By.xpath("(//*[@class='blogCard context-menu'])[1]"),popularBlogs);
		return popularBlogs;
	}
	
	@FindBy(xpath="//div[@class='app-store-img']")
	WebElement appStoreImage;
	
	public WebElement getAppstoreImage() {
		synchronised(By.xpath("//div[@class='app-store-img']"),appStoreImage);
		return appStoreImage;
	}
	
	@FindBy(xpath="//div/h2[@class='cal-popup-heading']")
	WebElement guestUserPopup;
	
	public WebElement getGuestUserPopup() {
		synchronised(By.xpath("//div/h2[@class='cal-popup-heading']"),guestUserPopup);
		return guestUserPopup;
	}
	
	@FindBy(xpath="(//i[@class='sc-cSHVUG hupUHU'])[1]")
	WebElement facebookIcon;
	
	public WebElement getFacebookIcon() {
		synchronised(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[1]"),facebookIcon);
		return facebookIcon;
	}
	
	@FindBy(xpath="(//i[@class='sc-cSHVUG hupUHU'])[2]")
	WebElement twitterIcon;
	
	public WebElement getTwitterIcon() {
		synchronised(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[2]"),twitterIcon);
		return twitterIcon;
	}
	
	@FindBy(xpath="(//i[@class='sc-cSHVUG hupUHU'])[3]")
	WebElement linkedInIcon;
	
	public WebElement getlinkedInIcon() {
		synchronised(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[3]"),linkedInIcon);
		return linkedInIcon;
	}
	
	@FindBy(xpath="(//i[@class='sc-cSHVUG hupUHU'])[4]")
	WebElement instagramIcon;
	
	public WebElement getInstagramIcon() {
		synchronised(By.xpath("(//i[@class='sc-cSHVUG hupUHU'])[4]"),instagramIcon);
		return instagramIcon;
	}
	
	@FindBy(xpath="//img[@src='https://rewardflightfinder.com/static/media/google-play.b6d3fc79.png']")
	WebElement playstoreImage;
	
	public WebElement getPlaystoreImage() {
		synchronised(By.xpath("//img[@src='https://rewardflightfinder.com/static/media/google-play.b6d3fc79.png']"),playstoreImage);
		return playstoreImage;
	}
	
	@FindBy(xpath="//img[@src='https://rewardflightfinder.com/static/media/app-store-img.626b8ae3.png']")
	WebElement applestoreImage;
	
	public WebElement getApplestoreImage() {
		synchronised(By.xpath("//img[@src='https://rewardflightfinder.com/static/media/app-store-img.626b8ae3.png']"),applestoreImage);
		return applestoreImage;
	}

	@FindBy(xpath="//div[@class='x92rtbv x10l6tqk x1tk7jg1 x1vjfegm']")
	WebElement fbCloseButton;
	
	public WebElement getFbCloseButton() {
		synchronised(By.xpath("//div[@class='x92rtbv x10l6tqk x1tk7jg1 x1vjfegm']"), fbCloseButton);
		return fbCloseButton;
	}
	
	@FindBy(xpath="(//*[@class='artdeco-icon lazy-loaded'])[1]")
	WebElement linkedinCloseButton;
			
	public WebElement getLinkedinCloseButton() {
		synchronised(By.xpath("(//*[@class='artdeco-icon lazy-loaded'])[1]"), linkedinCloseButton);
		return linkedinCloseButton;
	}		
			
			
			
}
