package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager { // class declaration..

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) { // If report is NOT created → create it----If already created → reuse it
			String path = "reports/ExtentReport_" + System.currentTimeMillis() + ".html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(path);

			reporter.config().setReportName("Automation Test Reports");

			reporter.config().setDocumentTitle("Test Report");

			extent = new ExtentReports();

			extent.attachReporter(reporter); // ExtentReports → ExtentSparkReporter Without this:Report won’t generate.
		}
		return extent;
	}

}
