package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By userName = By.xpath("//input[@placeholder='Enter Email']");
	By password = By.xpath("//input[@placeholder='Enter Password']");
	By loginBtn = By.xpath("//button[contains(text(), 'Sign in')]");

	public void loginToApp(String userName1, String password1) {
		driver.findElement(userName).sendKeys(userName1);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(loginBtn).click();
	}

}
