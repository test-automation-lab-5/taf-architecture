package com.epam.fivethreads.page;

import static com.epam.fivethreads.constant.Constant.ALERT_WAIT_TIME;

import com.epam.fivethreads.driverfactory.SafeThreadDriverCreator;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.fivethreads.customfielddecorator.CustomFieldDecorator;
import com.epam.fivethreads.propmodel.GmailData;

public abstract class AbstractPage {
	private static final Logger LOG = Logger.getLogger(AbstractPage.class);
	protected final WebDriver driver;
	protected final GmailData gmailData;

	public AbstractPage() {
		//this.driver  = DriverManagerFactory.getDriver();    //One Driver
		this.driver  = SafeThreadDriverCreator.getInstance().getDriver();  //Multi-thread driver
		//LOG.info(" ---- Driver has been initialized in AbstractPage().Constructor() ---- ");
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
		gmailData = new GmailData();
		LOG.info(" ---- PageFactory has been initialized in AbstractPage().Constructor() ---- ");
		
	}
	
	
	//--------------Additional --------------
	public boolean isElementPresent(By locator) {
return driver.findElements(locator).size()>0;}
	
	protected boolean isSearchElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void waitForElementToLoad(WebElement element) {
		int secondsCount = 0;
		boolean isElementShownIndicator = isSearchElementDisplayed(element);
		while (!isElementShownIndicator && secondsCount < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			secondsCount++;
			isElementShownIndicator = isSearchElementDisplayed(element);
		}
		if (!isElementShownIndicator) {
			throw new AssertionError("Element was not shown");
		}
	}

		public boolean isAlertPresent() {
			boolean foundAlert = false;
			WebDriverWait wait = new WebDriverWait(driver, ALERT_WAIT_TIME);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				foundAlert = true;
			} catch (TimeoutException eTO) {

			}

			return foundAlert;
		}
}
