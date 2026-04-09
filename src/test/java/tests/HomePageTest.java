package tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.LoggerUtil;

@Listeners(listeners.TestListener.class)
public class HomePageTest extends BaseTest {

	Logger log = LoggerUtil.getLogger(HomePageTest.class);

	@Test

	public void goToHomePage() {

		log.info("Clicking HomePage");

		LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.clickloginbtn();

		log.info("Login Successfull...");

		HomePage homepage = new HomePage(DriverFactory.getDriver());
		homepage.clickHomeButton();
		log.info("clicked HomePage");
		
		
		
		
	}
}
