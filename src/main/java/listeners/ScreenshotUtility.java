package listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver) {
            String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            return screenshotBase64;
        }
}

