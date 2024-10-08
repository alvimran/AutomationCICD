package rahulshettyacademy.Data;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReportNG;
import rahulshettyacademyTestComopents.Base;

public class Listeners extends Base implements ITestListener{
	ExtentReports  extent=ExtentReportNG.getReportObejct();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	@Override  
	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
		extentTest.get().log(Status.PASS, "Test Passed");
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
		extentTest.get().fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	String filepath = null;
	try {
		filepath = getScreenShoot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	extentTest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
		extent.flush();
	}  

	
}
