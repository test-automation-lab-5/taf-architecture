package main.pages.decorator.elements;

import main.pages.decorator.elements.interfaces.LinkInterface;
import org.openqa.selenium.WebElement;

public class Link extends AbstractElement implements LinkInterface {
    public Link(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
