package Others;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHeadless {

	public static void main(String[] args) throws Throwable {
		
		
		ChromeOptions options = new ChromeOptions ();

		options.addExtensions (new File("C:\\Users\\wbox42\\eclipse-workspace\\FlightFinder\\src\\test\\resources\\Unconfirmed 767524.crdownload"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("chrome-extension://mkpcaklladfpajiaikehdinfaabmnajh/popup/popup.html");
		Thread.sleep(3000);
		String email = driver.findElement(By.id("eaddr")).getAttribute("data-clipboard-text");
		System.out.println("Email id is  "+ email);
		driver.findElement(By.xpath("//a[text()='INBOX']")).click();
		
	}
	
	
}
