package listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.flightfinder.genericutility.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ExtentReportListener implements ITestListener {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./ExtentReport/TestExecutionReport.html");
		sparkReporter.config().setDocumentTitle("Test Report");
		sparkReporter.config().setReportName("Test Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Tester");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getDescription();
		ExtentTest extentTest = extent.createTest(testName);
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed");
		test.get().log(Status.FAIL, result.getThrowable());
		File scrFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			String fileName = generateFileName();
			File destFile = new File("failure_screenshots/" + fileName + ".png");
			FileUtils.copyFile(scrFile, destFile);

			// Add screenshot to the report
			test.get().addScreenCaptureFromPath("../failure_screenshots/" + fileName + ".png", "Screenshot on failure");

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Not implemented
	}

	public static void logMessage(String message) throws IOException {
		test.get().info(message);
	}

	public static void screenshot(String screenshotPath1,String message) throws IOException {
		test.get().info(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());

	}

	private static String generateFileName() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		return now.format(formatter);
	}

}
