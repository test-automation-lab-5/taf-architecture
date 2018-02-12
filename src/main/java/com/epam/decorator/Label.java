package com.epam.decorator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Label extends AbstractElement {
    private static final Logger LOG = Logger.getLogger(Label.class);

    public Label (WebElement webElement) {
        super(webElement);
    }

    public String getText (){

        LOG.info (String.format("Getting text  %d",Thread.currentThread().getId()));
        return webElement.getAttribute("innerHTML");

    }
}
