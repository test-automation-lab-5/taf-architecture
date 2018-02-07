package com.epam.fivethreads.page;

//import static com.epam.fivethreads.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;

import com.epam.fivethreads.elements.single.Button;
import com.epam.fivethreads.elements.single.TextField;

public class LogInPage extends AbstractPage {

	private static final Logger LOG = Logger.getLogger(LogInPage.class);

	@FindBy(xpath = "//input[@type='email'][@name='identifier']")
	// @CacheLookup
	// private WebElement logInField;
	private TextField logInField;

	@FindBy(id = "identifierNext")
	// @CacheLookup
	// private WebElement logInNextButton;
	private Button logInNextButton;

	public void openPage() {
		LOG.info("START ---- LogInPage.openPage() ---- ");
		driver.get(gmailData.getGmailLink());
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			LOG.info("!!!!!!!!!!!!!!! ---- LogInPage.alert ---- "+isAlertPresent());
			LOG.info(" Alert = "+alert);
			//alert.accept();
			alert.accept();
		}
	}

	public PasswordPage inputLogIn(String userLogin) {
		logInField.type(userLogin);
		logInNextButton.click();
		return new PasswordPage();

	}

}
