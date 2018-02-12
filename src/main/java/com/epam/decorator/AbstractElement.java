package com.epam.decorator;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement {
 WebElement webElement;
 AbstractElement(WebElement webElement) {

        this.webElement = webElement;
        }

public WebElement getWebElement() {
        return webElement;
        }



}
