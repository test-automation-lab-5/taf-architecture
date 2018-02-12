package com.epam.decorator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextInput extends  AbstractElement {

    private static final Logger LOG = Logger.getLogger(TextInput.class);

    public TextInput(WebElement webElement) {

        super(webElement);
    }

    public void enterText(String string){

        webElement.sendKeys(string);
        LOG.info(String.format("TextInput was entered  %d", Thread.currentThread().getId()));
    }
}
