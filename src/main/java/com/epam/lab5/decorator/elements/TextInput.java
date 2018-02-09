package com.epam.lab5.decorator.elements;

import org.openqa.selenium.WebElement;

public class TextInput extends  PageElement {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        super.sendKeys(charSequences);
    }
}
