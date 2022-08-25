package Pages;

import org.openqa.selenium.By;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass{

	By username = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By loginButton = By.xpath("//input[@id='login-button']");
	
	
	public void enterCredentials(String user, String pwd) { 
	  driver.findElement(username).sendKeys(user);
	  driver.findElement(password).sendKeys(pwd);
	  driver.findElement(loginButton).click();
	  
	  
}
	
}