package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BaseClass.BaseClass;

public class CheckoutPage {
	
	private WebDriver driver;
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By fstName = By.xpath("//input[@id='first-name']");
	By lstname = By.xpath("//input[@id='last-name']");
	By postalCode = By.xpath("//input[@id='postal-code']");
	By continueButton = By.xpath("//input[@id='continue']");
	By finishbtn= By.xpath("//button[@id='finish']");
	By backTomainpage = By.xpath("//button[@id='back-to-products']");
	
	public CheckoutPage enterUserInformation(String firstName , String lastName, String pinCode) {
		  driver.findElement(fstName).sendKeys(firstName);
		  driver.findElement(lstname).sendKeys(lastName);
		  driver.findElement(postalCode).sendKeys(pinCode);
		  driver.findElement(continueButton).click();
		  return this;
		  
	}
	
	public CheckoutPage backToProducts() {
		 driver.findElement(finishbtn).click();
		  driver.findElement(backTomainpage).click();
		  return this;
	}
}
