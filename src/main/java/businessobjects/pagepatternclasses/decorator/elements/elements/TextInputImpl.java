package businessobjects.pagepatternclasses.decorator.elements.elements;

import businessobjects.pagepatternclasses.decorator.elements.elements.elementsInterface.TextInput;
import org.openqa.selenium.WebElement;

public class TextInputImpl extends AbstractElement implements TextInput {
    public TextInputImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(String text) {
        webElement.sendKeys(text);
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    public boolean isPresent(){
        return webElement.isDisplayed();
    }
}

