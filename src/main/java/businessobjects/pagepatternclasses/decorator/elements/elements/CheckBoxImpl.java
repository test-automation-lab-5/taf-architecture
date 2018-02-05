package businessobjects.pagepatternclasses.decorator.elements.elements;

import businessobjects.pagepatternclasses.decorator.elements.elements.elementsInterface.CheckBox;
import org.openqa.selenium.WebElement;

public class CheckBoxImpl extends AbstractElement implements CheckBox {
    public CheckBoxImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
