package com.epam.fivethreads.driverfactory;

import static com.epam.fivethreads.constant.Constant.FIREFOX_DRIVER_PATH;
import static com.epam.fivethreads.constant.Constant.FIREFOX_DRIVER_TYPE;
import static com.epam.fivethreads.constant.Constant.GLOBAL_WAIT_TIME;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirefoxDriverManager extends DriverManager {

	@Override
	protected WebDriver createDriver() {
		System.setProperty(FIREFOX_DRIVER_TYPE, FIREFOX_DRIVER_PATH); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);
		return driver;
	}
}
