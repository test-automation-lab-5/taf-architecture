package com.epam.lab.facadetask.decorator.bo.elements;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        webElement.click();
    }
}
