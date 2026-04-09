package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.LoggerUtil;

public class PracticePage extends BasePage {

	public PracticePage(WebDriver driver) {
		super(driver);

	}

	// Page Elements

	@FindBy(xpath = "//a[text()='Practice']")
	private WebElement clickPracticePage;

	@FindBy(xpath = "//input[contains(@value,\"Java\")]")
	private WebElement clickJavaBtn;

	@FindBy(xpath = "//a[contains(text(),\"Test Table\")]")
	private WebElement clickTestTable;

	@FindBy(xpath = "//input[contains(@value,\"Intermediate\")]")
	private WebElement clickIntermediatebtn;

	@FindBy(xpath = "//input[contains(@value,\"Advanced\")]")
	private WebElement clickAdvancedbtn;

	@FindBy(xpath = "//div[@class='dropdown-button']")
	private WebElement clickDropDown;

	
	@FindBy(xpath = "//table[@id='courses_table']/tbody/tr/td[5]")
	private List<WebElement> enrollmentValues;
	
	
	
	// Page Actions

	public void userClicksPractice() {
		click(clickPracticePage);

	}

	public void TestTable() {
		click(clickTestTable);
	}

	public void FilterJavaTest() {
		click(clickJavaBtn);
	}

	public void FilterAdvancedTest() {
		click(clickAdvancedbtn);
	}

	public void FilterIntermediateTest() {
		click(clickIntermediatebtn);
	}

	public boolean selectDropDown(String value) {
		selectCustomDropdown(clickDropDown, value);
		return true;
	}
	
	
	public boolean areAllValuesAboveTenThousand() {
	    for (WebElement price : enrollmentValues) {
	        String text = price.getText().replace(",", "").replace("+", "").trim();
	        
	        // IMPORTANT FIX
	        if (text.isEmpty()) {
	            LoggerUtil.info("Skipping empty value");
	            continue;
	        }


	        int value = Integer.parseInt(text);

	        if (value < 10000) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	
	
	
	
	

	private By TableRows = By.xpath("//table[@id='courses_table']/tbody/tr");

	public List<WebElement> getRows() {
		return driver.findElements(TableRows);
	}

	public String getCellValue(WebElement row, int columnIndex) {
		return row.findElement(By.xpath("./td[" + columnIndex + "]")).getText().trim();

	}

	public boolean verifyColumnText(int columnIndex, String expectedText) {
		for (WebElement row : getRows()) {

			String actual = getCellValue(row, columnIndex);

			System.out.println("Actual Data: " + actual);

			if (actual.isEmpty()) {
				System.out.println("Skipping empty row");
				continue;
			}

			if (!actual.equalsIgnoreCase(expectedText)) {
				System.out.println("Mismatch Found!: Expected: " + expectedText + "But got: " + actual);
				return false;
			}
		}
		return true;
		
	
	
		
	}
}
