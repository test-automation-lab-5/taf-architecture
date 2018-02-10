package main.pages;

import main.constants.Constants;
import main.pages.decorator.elements.AbstractElement;
import main.pages.decorator.factory.CustomPageFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractGmailPage {

    WebDriver driver;

    AbstractGmailPage(WebDriver driver) {
        this.driver = driver;
        CustomPageFactory.initElements(driver, this);
    }

    void waitUntilTextToBePresentInElement(AbstractElement element, String text) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElementValue(element.getWebElement(), text));
    }

    void waitUntilAttributeBeVisible(AbstractElement element) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.attributeToBeNotEmpty(element.getWebElement(), Constants.STYLE));
    }

    public void waitUntilUrlWillContains(String value) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.urlContains(value));
    }

    boolean waitUntilAlertBePresent() {
        try {
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }

    }
}
