package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public class Element implements IElement {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
    }

    public boolean isDisplayed() {

        return webElement.isDisplayed();
    }
    public boolean isEnabled(){
        return webElement.isEnabled();
    }
    public String getText() {
        return webElement.getText();
    }
}
