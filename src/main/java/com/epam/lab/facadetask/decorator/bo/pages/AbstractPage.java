package com.epam.lab.facadetask.decorator.bo.pages;

import com.epam.lab.facadetask.decorator.handler.CustomPageFactory;
import com.epam.lab.facadetask.decorator.bo.elements.ElementFactory;
import com.epam.lab.facadetask.driver.DriverObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    private WebDriver driver;
    private ElementFactory elementFactory = new ElementFactory();

    AbstractPage(CustomPageFactory pageFactory) {
        this.driver = DriverObject.getDriver();
        pageFactory.initElements(driver, this);
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, 30));
    }

    protected WebElement waitToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitToBeVisible(WebElement element){
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }
}