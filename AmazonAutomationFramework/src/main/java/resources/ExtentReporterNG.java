package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	

	public static ExtentReports getReportObject() {
		ExtentReports extent;

		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Amazon Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Roopant");
		return extent;
		
	
		
	}
	
}
