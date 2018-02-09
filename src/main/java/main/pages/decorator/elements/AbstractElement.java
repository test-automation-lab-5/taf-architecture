package main.pages.decorator.elements;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement {
    protected WebElement webElement;

    public AbstractElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
