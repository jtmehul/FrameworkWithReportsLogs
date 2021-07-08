package dps.com.testproj;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCLS {

	
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	
	
public static ExtentReports getReportObject(){
		
		String path = System.getProperty("user.dir")+"\\reports\\ExtentReportResults.html";
		System.out.println(path);
		//Checked if extent objects already existed 
		if (extent != null) return extent;
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Reports");
		reporter.config().setDocumentTitle("Web Automation Testing");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Mehul Thakar");
		extent.getStats();
		return extent;		
	}
}
