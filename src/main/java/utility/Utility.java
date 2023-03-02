package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {

	public static WebElement highlightElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", element);
		// waitForSeconds(1);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute('style','background: white; border: 2px solid white;')", element);

		return element;

	}

	public static Alert waitForAlert(WebDriver driver) throws Exception {

		Alert alt = null;

		for (int i = 0; i < 15; i++) {
			try {
				alt = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				System.out.println("No Alert Present - Waiting");
				waitForSeconds(1);
			}
		}
		return alt;

	}

	public static Alert waitForAlert(WebDriver driver, int time) throws Exception {

		Alert alt = null;

		for (int i = 0; i < time; i++) {
			try {
				alt = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				System.out.println("No Alert Present - Waiting");
				waitForSeconds(1);
			}
		}
		return alt;

	}

	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String captureScreenShotInBase64(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);

		return base64;

	}

	public static void captureScreenShots(WebDriver driver) {

		try {
			FileHandler.copy((((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)),
					new File("./Screenshots/Screenshot" + getCurrentDate() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	public static String getCurrentDate() {
		String date = (new SimpleDateFormat("hh.mm.ss-DD_MM_YYYY")).format(new Date());
		System.out.println(date);
		return date;
	}

	public static void captureElementScreenShots(WebDriver driver, WebElement ele) {

		try {

			FileHandler.copy((ele.getScreenshotAs(OutputType.FILE)),
					new File("./ElementScreenshots/Screenshot" + getCurrentDate() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}
}
