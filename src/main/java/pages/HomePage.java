package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.ExtentTestManager;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[contains(text(),\"Home\")]")
	private WebElement homeButton;
	
	
    public void clickHomeButton() {
    	ExtentTestManager.getTest().info("Clicking Home Button");
    	click(homeButton);
    } 
	
	
	
	

}
