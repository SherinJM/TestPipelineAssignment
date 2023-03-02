package listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browserFactory.BrowserFactory;
import utility.Utility;

public class ExtentTestNGTestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getInstance();
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// test start - add test
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		// test start - pass log
		WebDriver driver = BrowserFactory.getBrowserInstance();
		String sc = Utility.captureScreenShotInBase64(driver);
		parentTest.get().pass("Test Passed ",MediaEntityBuilder.createScreenCaptureFromBase64String(sc).build());

	}

	public void onTestFailure(ITestResult result) {
		// test start - fail log
		WebDriver driver = BrowserFactory.getBrowserInstance();
		String sc = Utility.captureScreenShotInBase64(driver);
		parentTest.get().fail("Test Failed " + result.getThrowable().getMessage(),
				MediaEntityBuilder.createScreenCaptureFromBase64String(sc).build());
	}

	public void onTestSkipped(ITestResult result) {
		// test start - skip log
		parentTest.get().skip("Test Skipped" + result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		// test start - add test
		extent.flush();
	}
}
