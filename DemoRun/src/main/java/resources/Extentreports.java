package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports 

{
	static ExtentReports extent;
	
	public static ExtentReports getreports()
	{
	String	path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("SeleniumEasyTutorial");
	reporter.config().setDocumentTitle("Test Results");
	
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "ABC");
	return extent;
	
	
	
		
	}

}
