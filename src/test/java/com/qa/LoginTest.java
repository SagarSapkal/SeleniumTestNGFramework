
 package com.qa;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseClass;
import BaseClass.ExcelUtility;
import Pages.CheckoutPage;
import Pages.ItemsPage;
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
		}
	}
	return loginData;
  }

  @Test(dataProvider= "loginTestData")
  public void loginTest(String user, String pwd,String firstName , String lastName, String pinCode,String expectedError)throws InterruptedException {
	 
	  System.out.println("loginTestData");
	  driver.get("https://www.saucedemo.com/");
	 
	  LoginPage loginpage = new LoginPage(driver);
	  ItemsPage itemPage = new ItemsPage(driver);
	  CheckoutPage checkoutPage = new CheckoutPage(driver);
	  
	  if(user.equalsIgnoreCase("standard_user") ) {
 
	  loginpage.enterCredentials(user, pwd);
	  itemPage.selectItem();
	  itemPage.checkoutItem();
	  checkoutPage.enterUserInformation(firstName, lastName, pinCode).backToProducts(); 
	  }
	  else if (user.equalsIgnoreCase("locked_out_user")) {
		  loginpage.enterCredentials(user, pwd);
		  loginpage.lockedUser(expectedError);
	  }
	  else {
		  Assert.assertTrue(true);
		  
	  }
	  
  }




}
