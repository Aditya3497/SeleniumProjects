package Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import Base.Base;

public class LoginPage extends Base {
	By lclose = By.id("alternate-login-close");
	By login = By.id("des_lIcon");
	By googleSignIn = By.xpath("(//span[text()='Continue with Google'])");
	By email = By.xpath("(//input[@type='email'])");
	By submit = By.xpath(
			"//span[text()='Next']");
	By error = By.xpath("(//div[@class='o6cuMc'])");

	public void clickLogin() // Method to click Login
	{
		logger = report.createTest("Displaying used car");
		try {
			driver.findElement(login).click();
			Thread.sleep(5000);
			String login1 = "Login/Register to";
			String ver = driver.findElement(By.xpath(
					"//span[text()='Continue with Google']"))
					.getText();
			if (ver.contains(login1))
				reportPass("Used Cars in chennai are displayed");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void clickGoogleSignIn() throws InterruptedException // Method to click Login
, IOException
	{
		logger = report.createTest("Error Checking after signup");
		Thread.sleep(5000);
		driver.findElement(googleSignIn).click();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
		driver.findElement(email).sendKeys("Hello@gml.com");
		driver.findElement(submit).click();
		Thread.sleep(3000);
		Screenshoot("error");
	}

	public void captureErrorMessage() // Method to capture error message
	{
		System.out.println("*******************************************************");
		System.out.println("              Error Obtained during Signup:");
		System.out.println("*******************************************************");
		String errorMessage = driver.findElement(error).getText();
		System.out.println("Error Message = " + errorMessage);
	}

}
