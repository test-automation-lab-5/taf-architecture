package com.epam.decorator;


import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;


public class Button extends AbstractElement {
    private static final Logger LOG = Logger.getLogger(Button.class);


    public Button (WebElement webElement) {
        super(webElement);
    }

    public void clickOn(){

        webElement.click();
        LOG.info(String.format("Button was clicked  %d", Thread.currentThread().getId()));
    }
}
