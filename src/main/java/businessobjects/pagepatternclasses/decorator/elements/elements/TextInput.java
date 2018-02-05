package businessobjects.pagepatternclasses.decorator.elements.elements;

import org.openqa.selenium.WebElement;
import businessobjects.pagepatternclasses.decorator.elements.elements.action.SendKeys;

public class TextInput extends AbstractElement implements SendKeys {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(String text) {
        webElement.sendKeys(text);
    }
    public String getText(){
        return webElement.getText();
    }
}

