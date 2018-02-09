package main.pages.decorator.elements;

import main.pages.decorator.elements.interfaces.InputInterface;
import org.openqa.selenium.WebElement;

public class Input extends AbstractElement implements InputInterface {
    public Input(WebElement webElement) {
        super(webElement);
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public void sendKeys(String key) {
        webElement.sendKeys(key);
    }

    @Override
    public void clickOn() {
        webElement.click();
    }
}
