package com.epam.lab.pages;

import com.epam.lab.decorator.CustomFieldDecorator;
import com.epam.lab.decorator.MyExpectedConditions;
import com.epam.lab.elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

class DefaultPage {
    private WebDriver webDriver;

    DefaultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements( new CustomFieldDecorator(webDriver), this);
    }


    private WebDriverWait getWait() {

        return (new WebDriverWait( webDriver, 20));
    }
    Element waitToBeClickable(Element element) {
        return getWait().until( MyExpectedConditions.elementToBeClickable(element));
    }
}
