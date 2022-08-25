package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	
  @Parameters({"browser"})
  @BeforeMethod
  public void beforeMethod(String browser) {
		
	String bw = browser;
	WebDriverFactory factory = new WebDriverFactory(bw);
	this.driver = factory.Createdriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		}
	  
	  
  
	  @AfterMethod
	  public void afterMethod() {
		 
		  driver.quit();
	  }
	
		  
	  
	  
	  
	  
	  
	  
  }

