package com.epam.task4.businessobjects.pageobjects;

import com.epam.task4.businessobjects.pageobjects.decorator.elements.AbstractElement;
import com.epam.task4.businessobjects.pageobjects.decorator.elements.MyElementFactory;
import com.epam.task4.businessobjects.pageobjects.decorator.heandlers.MyPageFactory;
import com.epam.task4.drivers.SingletonDriver;
import com.epam.task4.preferences.Preferences;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private WebDriver driver;
    private MyElementFactory elementFactory = new MyElementFactory();

    protected AbstractPage(MyPageFactory myPageFactory) {
        driver = SingletonDriver.getDriver();
        myPageFactory.initElements(driver, this);
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

    protected <E extends AbstractElement> E waitUntilBeClickable(E element) {
        return (E) elementFactory.create(element.getClass(), getWait().until(ExpectedConditions.elementToBeClickable(element.getWebElement())));
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, Preferences.preferencesTestGmail.getTimeOutInSeconds()));
    }
}