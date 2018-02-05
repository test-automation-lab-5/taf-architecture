package com.epam.decoratorpattern.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.epam.decoratorpattern.constant.Constant.*;

public class SentPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(SentPage.class);

	public void openPage() {
		LOG.info("START ---- SentPage.openPage() ---- ");
		driver.get(SENTED_URL);
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

	public boolean isMasageFound(String messageText) {
		List<WebElement> elementsDrafts = driver
				.findElements(By.xpath("//div[contains(text(),'" + String.format("%s", messageText) + "')]"));
		if (elementsDrafts.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
