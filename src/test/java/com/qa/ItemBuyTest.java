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
import Pages.CheckoutPage;
import Pages.ItemsPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ItemBuyTest extends BaseClass {

	

	  @DataProvider(name ="ItemBuyTest")
	  public String[][] loginTestData() throws IOException {
		  
		String path = "C:\\Users\\Sagar Sapkal\\eclipse-workspace\\2022_TestNGFramework\\src\\test\\resources\\DataProvider.xlsx";
		ExcelUtility util = new ExcelUtility(path );
		int cellCount= util.getcellCount("sheet2", 1);
		int rowCount = util.getRowCount("sheet2");
		
		String loginData[][] = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			
			for(int j=0; j<cellCount; j++) {
				
				loginData[i-1][j] =  util.getcellData("sheet2",i,j);
			}
		}
		return loginData;
	  }

	  @Test(dataProvider= "ItemBuyTest")
  public void loginTest(String user, String pwd,String firstName , String lastName, String pinCode,String expectedError) throws InterruptedException {
	
	  System.out.println("item buy test");
	  driver.get("https://www.saucedemo.com/");
	  
	  LoginPage loginpage = new LoginPage(driver);
	  ItemsPage itemPage = new ItemsPage(driver);
	  CheckoutPage checkoutPage = new CheckoutPage(driver);
	  
	  loginpage.enterCredentials(user, pwd);
	  itemPage.selectItem();
	  itemPage.checkoutItem();
	  checkoutPage.enterUserInformation(firstName, lastName, pinCode).backToProducts(); 
	 
  }



}
