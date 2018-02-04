package com.epam.task2.businessobjects.pageobjects;

import com.epam.task2.businessobjects.pageobjects.decorator.MyPageFactory;
import com.epam.task2.drivers.SingletonDriver;
import com.epam.task2.preferences.Preferences;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private WebDriver driver;

    protected AbstractPage() {
        driver = SingletonDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
    protected AbstractPage(boolean mpf) {
        driver = SingletonDriver.getDriver();
        MyPageFactory.initElements(driver, this);
    }

    protected void openPage(String pageURL) {
        driver.get(pageURL);
    }

    protected void waitPageRedirectToURL(String pageUrl) {
        waitUntilTrue(func -> driver.getCurrentUrl().equals(pageUrl));
    }

    protected void waitPageLoad() {
        waitUntilTrue(func ->
                ((JavascriptExecutor) func).executeScript("return document.readyState").equals("complete"));
    }

    protected void waitUntilTrue(ExpectedCondition<Boolean> expectedCondition) {
        getWait().until(expectedCondition);
    }

    protected WebElement waitUntilBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, Preferences.preferencesTestGmail.getTimeOutInSeconds()));
    }
}