package com.epam.fivethreads.businessobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.fivethreads.driverfactory.DriverManagerFactory;
import com.epam.fivethreads.driverfactory.DriverType;
import com.epam.fivethreads.page.DraftsPage;
import com.epam.fivethreads.page.LogInPage;
import com.epam.fivethreads.page.PasswordPage;
import com.epam.fivethreads.page.SentPage;
import com.epam.fivethreads.page.StartPage;

public class BasicBO {
	private static final Logger LOG = Logger.getLogger(BasicBO.class);
	protected WebDriver driver;

	
	public boolean initBrowser() {
		LOG.info(" ---- BasicBO.initBrowser() ---- ");
		this.driver = DriverManagerFactory.getDriver();
		LOG.info(" ----  BasicBO.initBrowser() ----  driver=" + driver + " ---- ");
		return (driver != null);
	}

	public void closeBrowser() {
		LOG.error(" ---- BasicBO.closeBrowser() ---- ");
		if (driver != null) {
			driver.close();
		}

	}
}
