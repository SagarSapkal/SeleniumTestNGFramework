package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BaseClass.BaseClass;

public class ItemsPage extends BaseClass{
	
	protected WebDriver driver;
	
	
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	By selectBag = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
	By addToCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By cartButton = By.xpath("//a[@class='shopping_cart_link']");
	By checkoutButton = By.xpath("//button[@id='checkout']");
	  
		
	public void selectItem() {
		
		  driver.findElement(selectBag).click();
		  driver.findElement(addToCart).click();
	}

	public void checkoutItem() {		  
		  driver.findElement(cartButton).click();
		  driver.findElement(checkoutButton).click();
	}
}
