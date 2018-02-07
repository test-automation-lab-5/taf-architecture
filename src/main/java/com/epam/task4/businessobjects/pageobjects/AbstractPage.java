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

import java.util.Objects;

abstract class AbstractPage {

    private WebDriver driver;
    private MyElementFactory elementFactory = new MyElementFactory();

    AbstractPage() {
        driver = SingletonDriver.getDriver();
        MyPageFactory.initElements(driver, this);
    }

    void openPage(String pageURL) {
        driver.get(pageURL);
    }

    void waitPageRedirectToURL(String pageUrl) {
        waitUntilTrue(func -> driver.getCurrentUrl().equals(pageUrl));
    }

    void waitPageLoad() {
        waitUntilTrue(func ->
                !Objects.isNull(func) && ((JavascriptExecutor) func).executeScript("return document.readyState").equals("complete"));
    }

    void waitUntilTrue(ExpectedCondition<Boolean> expectedCondition) {
        getWait().until(expectedCondition);
    }

    <E extends AbstractElement> E waitUntilBeClickable(E element) {
        return elementFactory.create((Class<E>) element.getClass(), getWait().until(ExpectedConditions.elementToBeClickable(element.getWebElement())));
    }

    private WebDriverWait getWait() {
        return (new WebDriverWait(driver, Preferences.preferencesTestGmail.getTimeOutInSeconds(), Preferences.preferencesTestGmail.getSleepInMillis()));
    }
}