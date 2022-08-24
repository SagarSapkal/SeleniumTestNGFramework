package com.qa;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import BaseClass.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ItemBuyTest extends BaseClass {

	

  @Test
  public void loginTest() throws InterruptedException {
	
	  System.out.println("item buy test");
	  driver.get("https://www.saucedemo.com/");
	 
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
	  
	  driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

	  driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	  driver.findElement(By.xpath("//button[@id='checkout']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Aman");
	  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Chawala");
	  driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("L4V 3B2");
	  driver.findElement(By.xpath("//input[@id='continue']")).click();
	  
	  driver.findElement(By.xpath("//button[@id='finish']")).click();
	  driver.findElement(By.xpath("//button[@id='back-to-products']")).click();	
	 
  }



}
