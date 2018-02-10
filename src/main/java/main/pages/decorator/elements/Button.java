package main.pages.decorator.elements;

import main.pages.decorator.elements.interfaces.ButtonInterface;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement implements ButtonInterface {
    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
