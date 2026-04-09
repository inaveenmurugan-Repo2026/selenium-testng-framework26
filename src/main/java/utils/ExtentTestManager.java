package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static void setTest(ExtentTest extentTest) {
		test.set(extentTest);
	}

	public static ExtentTest getTest() {

		return test.get();

	}
}
//Thread 1 → LoginTest
//Thread 2 → HomeTest
//Thread 3 → PracticeTest