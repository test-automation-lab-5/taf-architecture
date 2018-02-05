package com.epam.task2.businessobjects.pageobjects.decorator.elements;

import com.epam.task2.businessobjects.pageobjects.decorator.elements.actions.Click;
import org.openqa.selenium.WebElement;

public class CheckBox extends AbstractElement implements Click{
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
