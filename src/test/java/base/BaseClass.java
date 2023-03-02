package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;
import pages.LoginPage;

public class BaseClass {

	public WebDriver driver;


	@BeforeMethod
	public void setUpBrowser() throws Exception {
		System.out.println("LOG:INFO - Setting up browser");
		driver = BrowserFactory.startBrowser(ConfigReader.getProperty("Browser"), ConfigReader.getProperty("Url"));
		System.out.println("LOG:INFO - Application is up and running");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("LOG:INFO - Quitting browser");
		driver.quit();

	}
}
