package listeners;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;

import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.LoggerUtil;
import utils.ScreenshotUtil;
import factory.DriverFactory;

public class TestListener implements ITestListener { // Listener is: “A class that listens to test execution events and
														// reacts”

	private static final Logger log = LoggerUtil.getLogger(TestListener.class);

	ExtentReports extent = ExtentManager.getInstance();
	// ExtentTest test;
	// ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // Each test gets its own
	// copy of ExtentTest insead of only
	// one.Without ThreadLocal: it will overwritten latest report
	// withold one. Test//is a ThreadLocal container
//	Thread 1 → ExtentTest (LoginTest)
//	Thread 2 → ExtentTest (HomeTest)
//	Thread 3 → ExtentTest (PracticeTest) all stored inside test.

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Listener onTestStart triggered for: " + result.getName());
		ExtentTest extentTest = extent.createTest(result.getName()); // Gets test method name and Creates entry in
		ExtentTestManager.setTest(extentTest); // report:
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass(result.getName() + "\" Passed Successfully.\"");

		// test.get().pass("Test Passed..."); we replaced with common utility file for
		// gettest

//It updates the report like:
//Test Name: loginTest
//Status: PASS 
//Message: Test Passed //TestNG knows test passed,BUT Extent Report does NOT know unless you tell it

		log.info("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) { // this test runs automatically when test fails
		log.info("Listener triggered for failure");
		String testName = result.getName(); // get test method name

		WebDriver driver = DriverFactory.getDriver();
		String path = ScreenshotUtil.captureScreenshot(driver, testName);
		ExtentTestManager.getTest().fail(result.getThrowable());

		// test.get().fail(result.getThrowable()); // Gives:Exception,Error
		// message,Stack trace

		try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(path);
			// test.get().addScreenCaptureFromBase64String(path); // Adds image to report

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.error("Test Failed: " + testName);
		log.error("Screenshot Location: " + path);
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {
		log.info("===== TEST EXECUTION SUMMARY =====");
		log.info("Passed: " + context.getPassedTests().size());
		log.info("Failed: " + context.getFailedTests().size());
		log.info("Skipped: " + context.getSkippedTests().size());
		extent.flush();
	}

}

//Testng's' other interfaces=public interface ITestListener {
//
//void onTestStart(ITestResult result); default commands on testng
//
//void onTestSuccess(ITestResult result);
//
//void onTestFailure(ITestResult result);
//
//void onTestSkipped(ITestResult result);
//
//void onFinish(ITestContext context);
//}