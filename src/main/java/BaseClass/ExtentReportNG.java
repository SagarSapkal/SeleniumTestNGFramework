package BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	private static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	private static ExtentReports extent;
	
	public static ExtentReports extentReport(){
	 extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	spark.config().setDocumentTitle("TestNG Framework");
	spark.config().setReportName("Regression Test");
	extent.attachReporter(spark);
	extent.setSystemInfo("Automation Testing", "Author:Sagar Sapkal");
	
	return extent;
	}
	
	public static ExtentTest extentTest(String testName ) {
		extentTest.set(extent.createTest(testName));
		return extentTest.get();	
	}
}
