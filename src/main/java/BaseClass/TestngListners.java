package BaseClass;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

public class TestngListners implements ITestListener, IReporter{
	

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
	}

	@Override
	public IReporterConfig getConfig() {
		// TODO Auto-generated method stub
		return IReporter.super.getConfig();
	}

	public void onStart(ITestContext context) {	
		System.out.println("onStart method started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started" +result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method" +result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method" +result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" +result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
	}
	
	
	
}
