package edu.epam.seleniumexample.decorator;

import org.openqa.selenium.WebElement;

public class TextInput extends AbstractElement implements Element {

    public TextInput(WebElement wrapElement) {
        super(wrapElement);
    }

    public void sendKeys(String text) {
        wrapElement.sendKeys(text);
    }

    public boolean isDisplayed() {
        return wrapElement.isDisplayed();
    }
}
