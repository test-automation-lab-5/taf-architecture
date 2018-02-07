package com.epam.fivethreads.page;

import static com.epam.fivethreads.constant.Constant.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class InboxPage extends AbstractPage{
	private static final Logger LOG = Logger.getLogger(InboxPage.class);
	
	public void openPage() {//Isn't tested
		LOG.info("START ---- InboxPage.openPage() ---- ");
		driver.get(INBOX_URL);
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}
	
	
}
