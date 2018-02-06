package com.epam.lab.facadetask.pages;

import com.epam.lab.facadetask.driver.DriverObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AbstractPage {
    private WebDriver driver;

    AbstractPage() throws IOException {
        this.driver = DriverObject.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, 40));
    }

    protected WebElement waitToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitToBeVisible(WebElement element){
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }
}