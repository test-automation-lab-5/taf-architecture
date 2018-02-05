package businessobjects.pagepatternclasses.decorator.elements.elements;

import businessobjects.pagepatternclasses.decorator.elements.elements.elementsInterface.Button;
import org.openqa.selenium.WebElement;

public class ButtonImpl extends AbstractElement implements Button {

    public ButtonImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
