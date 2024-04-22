package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLandingPage {
	
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://rff_stage:2024_RFF_Access@Staging.beta.rewardflightfinder.com");
			driver.findElement(By.xpath("//button[text()='I agree']")).click();
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			driver.close();
			driver.quit();
		}
}
