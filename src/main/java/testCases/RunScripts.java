package testCases;

import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.BitaWrapper;

public class RunScripts extends BitaWrapper {

	@Test
	public void navigateToAboutUs() {
		HomePage hmPge = new HomePage();
		hmPge.goToAboutUs();
	}
}
