package com.epam.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class DefaultPage {
    private WebDriver webDriver;

    DefaultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private WebDriverWait getWait() {

        return (new WebDriverWait( webDriver, 20));
    }
    WebElement waitToBeClickable(WebElement element) {
        return getWait().until( ExpectedConditions.elementToBeClickable(element));
    }
}
