package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public class CheckBox extends Element {
    public CheckBox(WebElement webElement) {
        super( webElement );
    }
    public void setChecked(boolean value) {
        if (value != isSelected()) {
            webElement.click();
        }
    }
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public void click() {
        super.click();
    }
}
