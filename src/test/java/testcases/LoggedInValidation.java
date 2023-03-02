package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;

public class LoggedInValidation extends BaseClass {

	@Test(dataProvider = "loginDataSet", dataProviderClass = CustomDataProvider.class)
	public void loggedInVal() throws Exception {
		System.out.println("Logged In Validation");

	}

}
