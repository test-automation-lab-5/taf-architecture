package main.pages;

import main.pages.decorator.elements.AbstractElement;
import main.pages.decorator.factory.CustomPageFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractGmailPage {

    private static final Logger log = Logger.getLogger(AbstractGmailPage.class);

    WebDriver driver;

    protected AbstractGmailPage(WebDriver driver) {
        this.driver = driver;
        CustomPageFactory.initElements(driver, this);
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void waitUntilElementBeClickable(AbstractElement element, int seconds) {
        log.info(String.format("Wait %s seconds until element be clickable", seconds));
        (new WebDriverWait(driver, seconds)).until(ExpectedConditions.elementToBeClickable(element.getWebElement()));
    }

    public void waitUntilTextToBePresentInElement(AbstractElement element, String text) {
        log.info(String.format("Wait until text %s be present in element", text));
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElementValue(element.getWebElement(), text));
    }

    public void waitUntilUrlContains() {
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.urlMatches("compose"));
    }

    public void waitUntilAttributeBeVisible(AbstractElement element) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.attributeToBeNotEmpty(element.getWebElement(), "style"));
    }
}
