package com.epam.decoratorpattern.businessobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.decoratorpattern.driverfactory.DriverManagerFactory;
import com.epam.decoratorpattern.driverfactory.DriverType;
import com.epam.decoratorpattern.page.DraftsPage;
import com.epam.decoratorpattern.page.LogInPage;
import com.epam.decoratorpattern.page.PasswordPage;
import com.epam.decoratorpattern.page.SentPage;
import com.epam.decoratorpattern.page.StartPage;

public class BasicBO {
	private static final Logger LOG = Logger.getLogger(BasicBO.class);
	protected WebDriver driver;

	
	public boolean initBrowser(DriverType driverType) {
		LOG.error(" ---- BasicBO.initBrowser() ---- ");
		this.driver = DriverManagerFactory.getDriver();
		LOG.error(" ---- driver=" + driver + " ---- ");
		return (driver != null);
	}

	public void closeBrowser() {
		LOG.error(" ---- BasicBO.closeBrowser() ---- ");
		if (driver != null) {
			driver.close();
		}

	}
}
