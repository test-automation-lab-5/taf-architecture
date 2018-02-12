package edu.epam.seleniumexample.decorator;

import org.openqa.selenium.WebElement;

public class Button extends AbstractElement implements Element {

    public Button(WebElement wrapElement) {
        super(wrapElement);
    }

    public void click() {
        wrapElement.click();
    }

    public boolean isDisplayed() {
        return wrapElement.isDisplayed();
    }
}
