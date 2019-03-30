package pages;

import Object.keys.ObjectMapping;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

	public AboutUs goToAboutUs() {

		//String element = properties.getProperty("Home.aboutus.id");
		clickById(properties.getProperty(ObjectMapping.HOME_ABOUTUS_ID));
		return new AboutUs();
	}

	public Business goToBusiness() {

		return new Business();
	}

	public ContactUs goToContactUs() {
		clickById("");
		return new ContactUs();
	}

	public Courses goToCourses() {

		return new Courses();
	}
}
