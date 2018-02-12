package edu.epam.seleniumexample.decorator;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement implements Element {
    protected WebElement wrapElement;

    public AbstractElement(WebElement wrapElement) {
        this.wrapElement = wrapElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrapElement.isDisplayed();
    }
}
