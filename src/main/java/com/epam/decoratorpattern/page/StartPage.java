package com.epam.decoratorpattern.page;

import static com.epam.decoratorpattern.constant.Constant.IS_LOGGED_IN_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.epam.decoratorpattern.elements.single.Button;
import com.epam.decoratorpattern.elements.single.TextField;

public class StartPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(StartPage.class);

	@FindBy(xpath = "//div[@role='navigation']/preceding-sibling::div//div[@role='button']")
	// private WebElement composeButton;
	private Button composeButton;

	@FindBy(xpath = "//form[@enctype='multipart/form-data']//textarea[@name='to']")
	// private WebElement sentToTextarea;
	private TextField sentToTextarea;

	@FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")
	@CacheLookup
	//private WebElement messageTexbox;
	private TextField messageTexbox;

	@FindBy(xpath = "//form[@enctype='multipart/form-data']//input[@name='subjectbox']")
	//private WebElement subjectBox;
	private TextField subjectBox;


	public boolean isOpened() {
		String ss = driver.getCurrentUrl();
		return ss.equals(IS_LOGGED_IN_URL);
	}

	private void openNewMessageForm() {
		composeButton.click();
	}

	public void craeteMessage(String messageSentTo, String messageSubject, String messageText) {
		LOG.info("START ---- StartPage.craeteMessage() ---- ");
		openNewMessageForm();
		//sentToTextarea.sendKeys(messageSentTo);
		sentToTextarea.type(messageSentTo);
		sentToTextarea.click();
		messageTexbox.click();
		//Actions builder = new Actions(driver);
		subjectBox.click();
		//builder.moveToElement(subjectBox).build().perform();
		//subjectBox.sendKeys(messageSubject);
		subjectBox.type(messageSubject);
		//builder.moveToElement(messageTexbox).click().sendKeys(messageText).perform();
		messageTexbox.click();
		messageTexbox.type(messageText);
		//messageTexbox.sendKeys(Keys.ESCAPE);
		messageTexbox.type(Keys.ESCAPE);
		LOG.info("FINISH ---- StartPage.craeteMessage() ---- ");
	}

}
