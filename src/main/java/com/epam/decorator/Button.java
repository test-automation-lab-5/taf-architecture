package com.epam.decorator;

import org.openqa.selenium.WebElement;

public class Button extends AbstractElement implements  IButton {

    public Button (WebElement webElement) {
        super(webElement);
    }

    public void clickOn(){
        //логіка очікування
        getWrappedElement().click();
    }
}
