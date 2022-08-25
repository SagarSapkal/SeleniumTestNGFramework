package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass{
	protected WebDriver driver;
	protected String LockedoutError;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	

	By username = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By loginButton = By.xpath("//input[@id='login-button']");
	By getErrorMessage = By.xpath("//h3[@data-test='error']");
	
	
	
	public void enterCredentials(String user, String pwd) { 
		try {
			
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user);
			  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
			  driver.findElement(loginButton).click();  
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	  
}
	public void lockedUser(String expectedError) {
	  LockedoutError = driver.findElement(getErrorMessage).getText();
	  assertEquals(LockedoutError,expectedError);
	}
	
}