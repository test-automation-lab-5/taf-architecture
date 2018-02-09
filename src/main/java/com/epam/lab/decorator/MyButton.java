package com.epam.lab.decorator;

import org.openqa.selenium.WebElement;

public class MyButton extends MyWebElement {
    public MyButton(WebElement element) {
        super(element);
    }

    public void click(WebElement element) {
        element.click();
    }
}
