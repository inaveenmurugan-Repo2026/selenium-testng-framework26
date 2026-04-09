package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver(String browser) {

		switch (browser.toLowerCase()) {

		case "chrome":
			driver.set(new ChromeDriver());
			break;

		case "edge":
			driver.set(new EdgeDriver());
			break;

		case "firefox":
			driver.set(new FirefoxDriver());
			break;

		default:
			throw new RuntimeException("Browser not supported: " + browser);
		}

		if (driver != null) {

			getDriver().manage().window().maximize();
		}

	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();

		}

	}

}

//	public static void removeDriver() {
//		driver.remove();
//
//	}
