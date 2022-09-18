package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	protected WebDriver driver;
//	public static ExtentReports extent;
//	public static ExtentSparkReporter spark ;
//	public static ExtentTest test;
	
  @BeforeSuite
  
  public void beforeSuite() {
//	  extent = new ExtentReports();
//	  spark = new ExtentSparkReporter("extentReport.html");
//	  extent.attachReporter(spark);
  }
	
  @Parameters({"browser"})
  @BeforeMethod
  public void beforeMethod(String browser) {
	String bw = browser;
	WebDriverFactory factory = new WebDriverFactory(bw);
	this.driver = factory.Createdriver();
	System.out.println("driver thread"+ Thread.currentThread().getId());
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @AfterSuite
  public void afterSuite() {
//	  extent.flush();
  }

	  
  }

