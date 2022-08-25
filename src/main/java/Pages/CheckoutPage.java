package Pages;

import org.openqa.selenium.By;

import BaseClass.BaseClass;

public class CheckoutPage extends BaseClass {
	
	By fstName = By.xpath("//input[@id='first-name']");
	By lstname = By.xpath("//input[@id='last-name']");
	By postalCode = By.xpath("//input[@id='postal-code']");
	By continueButton = By.xpath("//input[@id='continue']");

	
	public void enterUserInformation(String firstName , String lastName, String pinCode) {
		  driver.findElement(fstName).sendKeys(firstName);
		  driver.findElement(lstname).sendKeys(lastName);
		  driver.findElement(postalCode).sendKeys(pinCode);
		  driver.findElement(continueButton).click();
	}
}
