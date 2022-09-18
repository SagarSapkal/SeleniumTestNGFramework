package com.qa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseClass;
import BaseClass.ExcelUtility;
import Pages.CheckoutPage;
import Pages.ItemsPage;
import Pages.LoginPage;

public class CancelOrderTest extends BaseClass {

	

	  @DataProvider(name ="cancelOrderTest")
	  public String[][] loginTestData() throws IOException {
		  
		String path = "C:\\Users\\Sagar Sapkal\\eclipse-workspace\\2022_TestNGFramework\\src\\test\\resources\\DataProvider.xlsx";
		ExcelUtility util = new ExcelUtility(path );
		int cellCount= util.getcellCount("sheet3", 1);
		int rowCount = util.getRowCount("sheet3");
		
		String loginData[][] = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			
			for(int j=0; j<cellCount; j++) {
				
				loginData[i-1][j] =  util.getcellData("sheet3",i,j);
			}
		}
		return loginData;
	  }

	  @Test(dataProvider= "cancelOrderTest")
  public void CancelOrderTesting(String user, String pwd,String firstName , String lastName, String pinCode,String expectedError) throws InterruptedException {
	
	
		  System.out.println("cancelOrderTest");
	  driver.get("https://www.saucedemo.com/");
	 
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterCredentials(user, pwd);
	  
	  ItemsPage itemPage = new ItemsPage(driver);
	  itemPage.selectItem();
	  itemPage.checkoutItem();
	  
	  CheckoutPage checkoutPage = new CheckoutPage(driver);
	  checkoutPage.enterUserInformation(firstName, lastName, pinCode).backToProducts(); 
	  	
	 
  }



}
