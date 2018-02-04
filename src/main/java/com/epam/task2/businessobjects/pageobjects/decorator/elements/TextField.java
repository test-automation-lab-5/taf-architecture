package com.epam.task2.businessobjects.pageobjects.decorator.elements;

import org.openqa.selenium.WebElement;

public class TextField extends AbstractElement {
    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... var1){
        webElement.sendKeys(var1);
    }
    public String getText(){
        return webElement.getAttribute("value");
    }
}
