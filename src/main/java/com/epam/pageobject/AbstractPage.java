package com.epam.pageobject;

import com.epam.decorator.AbstractElement;
import com.epam.decorator.CustomElementFactory;
import com.epam.decorator.CustomPageFactory;
import com.epam.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AbstractPage {

    private WebDriver driver;
    private CustomElementFactory elementFactory = new CustomElementFactory();

    AbstractPage() {
        driver = DriverManager.getDriver();
        CustomPageFactory.initElements(driver, this);
    }

    private WebDriverWait getWait() {
        return (new WebDriverWait(driver, 30));
    }

    void openPage(String pageURL) {
        driver.get(pageURL);
    }

    String  getTitle (){
        return driver.getTitle();
    }


    void waitUntilTitle(String title ) {
        getWait().until(ExpectedConditions.titleContains(title));
    }

    <E extends AbstractElement> void waitUntilBeClickable( E element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element.getWebElement()));
    }

    <E extends AbstractElement> void waitUntilVisible( E element) {
        getWait().until(ExpectedConditions.visibilityOf(element.getWebElement()));
    }


}
