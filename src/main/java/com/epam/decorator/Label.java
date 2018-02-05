package com.epam.decorator;

import org.openqa.selenium.WebElement;

public class Label extends AbstractElement implements ILabel {

    public Label (WebElement webElement) {
        super(webElement);
    }

    public String getText (){
        //логіка очікування
        return getWrappedElement().getAttribute("innerHTML");
    }
}
