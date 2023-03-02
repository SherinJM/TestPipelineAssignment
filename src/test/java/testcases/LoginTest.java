package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(dataProvider = "loginDataSet", dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String uName, String password) throws Exception {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginToApp(uName, password);
		// Assert.assertTrue(driver.findElement(By.xpath("//h4[@class='welcomeMessage']")).isDisplayed());

	}

}
