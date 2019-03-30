package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrappers {

	public static RemoteWebDriver driver;
	public static Properties properties;

	public void launchBrowser(String browserName, String url) {
		// TODO Auto-generated method stub
		try {

			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Reporter.reportStep(" Browser launched successfully ", "PASS");
			System.out.println(" Browser launched successfully ");

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep(" Error in launching the brower ", "FAIL");
			System.out.println(" Error in launching the brower ");
			System.exit(0);
		}
	}

	/**
	 * This method will enter the value to the text field using id attribute to
	 * locate
	 * 
	 * @param elementId
	 * @param value
	 */
	public void enterValueById(String elementId, String value) {

		try {
			driver.findElementById(elementId).sendKeys(value);
			Reporter.reportStep(" Data successfully entered ", "PASS");
		} catch (Exception e) {
			Reporter.reportStep(" Enter data failed ", "FAIL");
			System.out.println(" Enter data failed ");
		}
	}
	
	
	/**
	 * This method will enter the value to the text field using id attribute to
	 * locate
	 * 
	 * @param elementId
	 * @param value
	 */
	public void clickById(String elementId) {

		try {
			driver.findElementById(elementId).click();;
			Reporter.reportStep(" Clicked successfully ", "PASS");
		} catch (Exception e) {
			Reporter.reportStep(" Click failed ", "FAIL");
			System.out.println(" Click failed ");
		}
	}
	public void loadObjectMap() {
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("./page_properties/Object_Key.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
