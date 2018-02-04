package com.epam.task2.businessobjects.pageobjects.decorator.elements;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement {
    protected WebElement webElement;

    public AbstractElement(WebElement webElement) {
        this.webElement = webElement;
    }
}
