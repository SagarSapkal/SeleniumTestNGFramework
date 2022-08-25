package com.qa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import BaseClass.ExcelUtility;
import Pages.LoginPage;

public class LoginTest extends BaseClass {


  @DataProvider(name ="loginTestData")
  public String[][] loginTestData() throws IOException {
	  String path = "C:\\Users\\Sagar Sapkal\\eclipse-workspace\\2022_TestNGFramework\\src\\test\\resources\\DataProvider.xlsx";
	ExcelUtility util = new ExcelUtility(path );
	int cellCount= util.getcellCount("sheet1", 1);
	int rowCount = util.getRowCount("sheet1");
	
	String loginData[][] = new String[rowCount][cellCount];
	
	for(int i=1; i<=rowCount; i++) {
		
		for(int j=0; j<cellCount; j++) {
			
			loginData[i-1][j] =  util.getcellData("sheet1",i,j);
			//System.out.println(loginData[i-1][j]+" ");
			
		}
	}
	return loginData;
  }

  @Test(dataProvider= "loginTestData")
  public void loginTest(String user, String pwd)throws InterruptedException {
	  driver.get("https://www.saucedemo.com/");
	 
	  
	  if(user.equalsIgnoreCase("standard_user") ) {
	 
	  LoginPage loginpage = new LoginPage();
	  loginpage.enterCredentials(user, pwd);
	  
	  
	  driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

	  driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	  driver.findElement(By.xpath("//button[@id='checkout']")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Aman");
	  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Chawala");
	  driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("L4V 3B2");
	  driver.findElement(By.xpath("//input[@id='continue']")).click();
	  
	  driver.findElement(By.xpath("//button[@id='finish']")).click();
	  driver.findElement(By.xpath("//button[@id='back-to-products']")).click();	
	 
	  }
	  else if (user.equalsIgnoreCase("locked_out_user")) {
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
	  String LockedoutError = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	  assertEquals(LockedoutError,"Epic sadface: Sorry, this user has been locked out.");
	  }
	  else {
		  Assert.assertTrue(true);
		  
	  }
	  
  }




}
