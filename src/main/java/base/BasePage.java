package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.LoggerUtil;
import utils.WaitUtils;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected void click(WebElement element) {
		WaitUtils.waitForClickable(driver, element, 15);
		element.click();
		LoggerUtil.info("Clicked on element");
	}

	protected void type(WebElement element, String text) {
		WaitUtils.waitForVisibility(driver, element, 15);
		element.clear();
		element.sendKeys(text);
		LoggerUtil.info("Entered text on element");
	}

	protected String getText(WebElement element) {
		WaitUtils.waitForVisibility(driver, element, 10);
		return element.getText();
	}

	protected boolean isDisplayed(WebElement element) {
		WaitUtils.waitForVisibility(driver, element, 10);
		return element.isDisplayed();
	}

	protected void selectCustomDropdown(WebElement dropdown, String optionText) {
		WaitUtils.waitForClickable(driver, dropdown, 10);
		dropdown.click();

		WebElement option = driver.findElement(By.xpath("//li[text()='" + optionText + "']"));

		WaitUtils.waitForClickable(driver, option, 10);
		option.click();

		LoggerUtil.info("Selected custom dropdown option");
	}

	protected void selectDropdown(WebElement element, String type, String value) {
		WaitUtils.waitForClickable(driver, element, 10);

		Select dropdown = new Select(element);

		switch (type.toLowerCase()) {
		case "text":
			dropdown.selectByVisibleText(value);
			break;
		case "value":
			dropdown.selectByValue(value);
			break;
		case "index":
			dropdown.selectByIndex(Integer.parseInt(value));
		
			break;
		 default:
	            throw new IllegalArgumentException("Invalid dropdown type: " + type);
		}

		LoggerUtil.info("Selected dropdown: " + value);
	}

}
