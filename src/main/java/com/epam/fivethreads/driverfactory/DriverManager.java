package com.epam.fivethreads.driverfactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public abstract class DriverManager {
	private static final Logger LOG = Logger.getLogger(DriverManager.class);
	protected static WebDriver driver;
	protected abstract WebDriver createDriver();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		if (null == driver) {
			driver = createDriver();
		}
		return driver;
	}
}
