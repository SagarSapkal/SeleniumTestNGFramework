package BaseClass;

import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestngListners implements ITestListener,IReporter{
	
	ExtentReports extent = ExtentReportNG.extentReport();
	
	private ExtentTest test ;
	
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	
	
	public void onStart(ITestContext context) {	
		
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().pass("Successfully passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.FAIL, "onTestFailedButWithinSuccessPercentage");
		
	}
	
	
	
}
