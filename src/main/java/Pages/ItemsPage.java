package Pages;

import org.openqa.selenium.By;

import BaseClass.BaseClass;

public class ItemsPage extends BaseClass{

	
	public void selectItem() {
		
		  driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
		  driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

		  driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		  driver.findElement(By.xpath("//button[@id='checkout']")).click();
		  
		
		
	}
	  
	
}
