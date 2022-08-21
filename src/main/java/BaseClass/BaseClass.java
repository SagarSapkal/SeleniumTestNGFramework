package BaseClass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	
  @Parameters({"browser"})
  @BeforeMethod
  public void beforeMethod(String browser) {
		
	String bw = browser;
	WebDriverFactory factory = new WebDriverFactory(bw);
	driver = factory.Createdriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		}
	  
	  
  
	  @AfterMethod
	  public void afterMethod() {
		 
		  driver.quit();
	  }
	
		  
	  
	  
	  
	  
	  
	  
  }

