package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver, String testName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String basePath = System.getProperty("user.dir") + "/screenshots/";

		File folder = new File(basePath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String path = basePath + testName + "_" + timestamp + ".png";

		File dest = new File(path);
		System.out.println("Project root path: " + new File(".").getAbsolutePath());

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}

//Take Screenshot
//
//Save file
//
//Return file path 