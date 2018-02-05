package main.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractGmailPage {

    private static final Logger log = Logger.getLogger(AbstractGmailPage.class);

    WebDriver driver;

    public AbstractGmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    void waitUntilElementBeClickable(WebElement element, int seconds) {
        log.info(String.format("Wait %s seconds until element be clickable", seconds));
        (new WebDriverWait(driver, seconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    void waitUntilTextToBePresentInElement(WebElement element, String text) {
        log.info(String.format("Wait until text %s be present in element", text));
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }
}
