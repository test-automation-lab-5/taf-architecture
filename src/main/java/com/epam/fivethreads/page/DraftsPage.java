package com.epam.fivethreads.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.epam.fivethreads.elements.single.Button;
import com.epam.fivethreads.elements.single.TextField;

import static com.epam.fivethreads.constant.Constant.*;

public class DraftsPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(DraftsPage.class);

	@FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")
	@CacheLookup
	// private WebElement sentMessageForm;
	private TextField sentMessageForm;

	@FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table/tbody/child::tr[2]/descendant::table//div[@role='button'][1]")
	@CacheLookup
	// private WebElement sentFormButton;
	private Button sentFormButton;

	public void openPage() {
		LOG.info("START ---- DraftsPage.openPage() ---- ");
		driver.get(DRAFTS_URL);
		if (isAlertPresent()) {

			Alert alert = driver.switchTo().alert();
			LOG.info("!!!!!!!!!!!!!!! ---- DraftsPage.alert ---- "+isAlertPresent());
			LOG.info(" Alert = "+alert);
			//alert.accept();
			alert.accept();
		}
	}

	private WebElement findMessageByText(String messageText) {
		WebElement element = driver
				.findElement(By.xpath("//div[@role='link'][contains(.,'" + String.format("%s", messageText) + "')]"));
		return element;
	}

	public boolean isMasageFound(String messageText) {
		WebElement elementLinkDiv = findMessageByText(messageText);
		return elementLinkDiv.isDisplayed();
	}

	public void sendMasageFound(String messageText) {
		LOG.info("START ---- DraftsPage.sendMasageFound() ---- ");
		WebElement elementLinkDiv = findMessageByText(messageText);
		Actions builder = new Actions(driver);
		builder.moveToElement(elementLinkDiv).click().perform();
		sentFormButton.click();
	}

}
