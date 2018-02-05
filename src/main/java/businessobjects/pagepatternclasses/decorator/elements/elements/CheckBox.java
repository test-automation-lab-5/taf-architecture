package businessobjects.pagepatternclasses.decorator.elements.elements;

import org.openqa.selenium.WebElement;
import businessobjects.pagepatternclasses.decorator.elements.elements.action.Click;

public class CheckBox extends AbstractElement implements Click {
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
