package com.epam.decoratorpattern.driverfactory;

import static com.epam.decoratorpattern.constant.Constant.CHROME_DRIVER_PATH;
import static com.epam.decoratorpattern.constant.Constant.CHROME_DRIVER_TYPE;
import static com.epam.decoratorpattern.constant.Constant.GLOBAL_WAIT_TIME;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	@Override
	protected WebDriver createDriver() {
		System.setProperty(CHROME_DRIVER_TYPE, CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);
		return driver;
	}

}
