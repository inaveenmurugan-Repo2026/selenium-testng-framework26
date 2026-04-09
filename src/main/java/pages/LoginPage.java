package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.ExtentTestManager;
import utils.WaitUtils;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "submit")
	private WebElement loginbtn;

	@FindBy(xpath = "//h1[contains(text(),\"Logged In Successfully\")]")
	private WebElement getSuccessMessage;

	@FindBy(id = "error")
	private WebElement getErrorMessage;

	public void enterusername(String user) {
		ExtentTestManager.getTest().info("Entering Username: " + user);
		type(username, user);

	}

	public void enterpassword(String pwd) {
		ExtentTestManager.getTest().info("Entering Password");
		type(password, pwd);
	}

	public void clickloginbtn() {
		ExtentTestManager.getTest().info("Clicking Login Button");
		click(loginbtn);

	}

	public void login(String user, String pass) {
		enterusername(user);
		enterpassword(pass);
		clickloginbtn();

	}

	public boolean isSuccessMessageDisplayed() {
		return getSuccessMessage.isDisplayed();
	}

	public String getSuccessmessage() {
		return getText(getSuccessMessage);
	}

	public boolean isErrorMessageDisplayed() {
		return getErrorMessage.isDisplayed();
	}

	public String errormessage() {
		return getText(getErrorMessage);
	}

}
