package com.epam.fivethreads.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.epam.fivethreads.constant.Constant.*;

public class SentPage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(SentPage.class);

    public void openPage() {
        openPage(SENTED_URL);
    }

    public boolean isMasageFound1(String messageText) {
        openPage();
        List<WebElement> elementsDrafts = driver
                .findElements(By.xpath("//div[contains(text(),'" + String.format("%s", messageText) + "')]"));
        if (elementsDrafts.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isMasageFound(String subject) {
        openPage();
        WebElement elementsDrafts = driver
                .findElement(By.xpath("//table[@cellpadding='0']/tbody/tr/td[@class='xY a4W']/div/div/div/span[text()='" + subject + "']"));
        return elementsDrafts.isDisplayed();


    }

}
