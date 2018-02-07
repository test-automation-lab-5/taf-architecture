package com.epam.task4.businessobjects.pageobjects.decorator.elements;

import com.epam.task4.businessobjects.pageobjects.decorator.elements.actions.SendKeys;
import org.openqa.selenium.WebElement;

public class InputField extends AbstractElement implements SendKeys {
    public InputField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... var1) {
        webElement.sendKeys(var1);
    }

    public String getValue() {
        return webElement.getAttribute("value");
    }
}
