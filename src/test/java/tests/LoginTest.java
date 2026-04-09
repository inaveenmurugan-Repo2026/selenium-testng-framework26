package tests;

import base.BaseTest;
import factory.DriverFactory;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Data.TestData;
import utils.ExtentTestManager;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

	Logger log = LoggerUtil.getLogger(LoginTest.class);

	@Test(dataProvider = "validlogin", dataProviderClass = TestData.class)

	public void verifyValidLogin(String username, String password) {
		ExtentTestManager.getTest().info("Started Validating the Vaid Login Test");
		log.info("Started Valid Login Test");

		LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.login(username, password);

		ExtentTestManager.getTest().info("Validating Success Message");
		log.info("Validated the success Message");
		Assert.assertTrue(loginpage.isSuccessMessageDisplayed());
	}

	@Test(dataProvider = "InvalidLogin", dataProviderClass = TestData.class)

	public void verifyInvalidLogin(String username, String password) {
		ExtentTestManager.getTest().info("Invalid Login Test Started");

		log.info("Invalid Login Test Started...");

		LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.login(username, password);

		ExtentTestManager.getTest().info("Invalid Login Error Message Displayed");
		log.info("Error Message Displayed");
		Assert.assertTrue(loginpage.isErrorMessageDisplayed());

	}
}
