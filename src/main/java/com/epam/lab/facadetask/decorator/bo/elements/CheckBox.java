package com.epam.lab.facadetask.decorator.bo.elements;

import org.openqa.selenium.WebElement;

public class CheckBox extends AbstractElement {

    public CheckBox (WebElement webElement) {
        super(webElement);
    }

    public void click() {
        webElement.click();
    }
}
