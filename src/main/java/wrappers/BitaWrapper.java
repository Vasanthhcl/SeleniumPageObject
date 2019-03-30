package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BitaWrapper extends GenericWrappers {

	public static String TEST_CASE_NAME = null;
	public static String TEST_CASE_DESC = null;

	@BeforeSuite
	public void startAppLibraries() {
		Reporter.startResult();
		loadObjectMap();
	}

	@BeforeMethod
	public void launchBrowserBeforeNewTest() {
		Reporter.startTestReporting();
		launchBrowser("chrome", "https://bitaacademy.com/");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void endLibraries() {
		Reporter.endResult();
	}

}
