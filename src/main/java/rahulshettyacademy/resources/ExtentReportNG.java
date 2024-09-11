package rahulshettyacademy.resources;

import java.lang.module.ModuleDescriptor.Exports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportNG {
	
	public static ExtentReports getReportObejct()
	{
	String path=System.getProperty("user.dir") +"//reports//index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Imran khan");
	
	return extent;
	}

}
