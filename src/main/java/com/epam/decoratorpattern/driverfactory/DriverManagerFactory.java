package com.epam.decoratorpattern.driverfactory;

import org.openqa.selenium.WebDriver;

import com.epam.decoratorpattern.propmodel.WebDriverData;

public class DriverManagerFactory {
	// private static DriverManagerFactory driverManagerFactory=null;
	private static DriverManager driverManager;

	private DriverManagerFactory() {

	}

	private static DriverManager getManager() {
		WebDriverData webDriverData = new WebDriverData();
		String drType = webDriverData.getType();
		if (null == driverManager) {
			if (drType.equals(DriverType.CHROME.toString())) {
				driverManager = new ChromeDriverManager();
			} else if (drType.equals(DriverType.FIREFOX.toString())) {
				driverManager = new FirefoxDriverManager();
			}
			;
		}
		return driverManager;
	}

	public static WebDriver getDriver() {
		return getManager().getDriver();

	}

}
