package base;

import factory.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
//import utils.DriverFactory;
import utils.ScreenshotUtil;

public class BaseTest {

	// protected WebDriver driver;
	protected ConfigReader config;

	@BeforeMethod
	public void setUp() {

		config = new ConfigReader();

		System.out.println("Launching Browser..." + config.getBrowser());
		
		DriverFactory.initDriver(config.getBrowser());


		DriverFactory.getDriver().get(config.getURL());
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName());
		}

		if (DriverFactory.getDriver() != null) {
			DriverFactory.getDriver().quit();
			DriverFactory.getDriver();
		}
	}
}

//	public void tearDown() {
//
//		if (driver != null) {
//			driver.quit();
//			DriverFactory.removeDriver();
//		}
//	}



//@before method
////		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(config.getTimeout()));
//driver = DriverFactory.initDriver(config.getBrowser());
//DriverFactory.getDriver().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(config.getTimeout()));
//System.out.println("Opening URL..." + config.getURL());

// driver.get(config.getURL());