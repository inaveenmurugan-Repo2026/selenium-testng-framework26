package tests;

import java.sql.Driver;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.LoginPage;
import pages.PracticePage;
import utils.ExtentTestManager;
import utils.LoggerUtil;

@Listeners(listeners.TestListener.class)
public class PracticeTest extends BaseTest {

	private static final boolean True = false;
	Logger log = LoggerUtil.getLogger(PracticeTest.class);

	@Test(enabled = false)

	public void praticePageTestCase1() {

		log.info("logging in");

		LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.clickloginbtn();

		log.info("Successfully Logged in...");

		log.info("Practice Page Clicked...");

		PracticePage practice = new PracticePage(DriverFactory.getDriver());
		practice.userClicksPractice();

		log.info("Practice Page Opened Successfully...");
		ExtentTestManager.getTest().info("TestTable opened");

		practice.TestTable();
		log.info("Clicking Test Table");

		ExtentTestManager.getTest().info("Filter Java Clicked");
		practice.FilterJavaTest();
		log.info("Selected Filter Java");

		log.info("Verifying that all table rows have Java Language");
		boolean allJava = practice.verifyColumnText(3, "Java");

		Assert.assertTrue(allJava, "All rows have Java as Language");
		log.info("Verification Completed, All rows verified as Java");
		ExtentTestManager.getTest().info("Verified in All rows the language column is selected as java ");
	}

	@Test(enabled = false)

	public void practicepageTestCase2() {

		LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.clickloginbtn();

		log.info("Logged in successfully");

		PracticePage practice = new PracticePage(DriverFactory.getDriver());
		practice.userClicksPractice();
		log.info("User Clicked Practice Page");

		practice.TestTable();
		log.info("Entering TestTable");

		practice.FilterIntermediateTest();
		log.info("Clicked Intermediate button");

		practice.FilterAdvancedTest();
		log.info("Clicked Advanced button");

		boolean allBeginner = practice.verifyColumnText(4, "Beginner");

		Assert.assertTrue(allBeginner, "All the column as shown as Beginner");
		ExtentTestManager.getTest().info("Verified in All rows the language column is selected as Beginner ");

	}

	@Test
	public void practicepageTestCase3() {

		LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.clickloginbtn();

		log.info("User Logged In");

		PracticePage practice = new PracticePage(DriverFactory.getDriver());
		practice.userClicksPractice();
		log.info("User Entered Practice Page");

		practice.TestTable();
		log.info("User Clicked Test Table");

		practice.selectDropDown("10,000+");
		log.info("User clicked the DropDown");

		boolean tenThousand = practice.areAllValuesAboveTenThousand();
		Assert.assertTrue(tenThousand, "Verified all the values are above 10k only");
		log.info("User Verified all the values are above 10k only");

	}

}
