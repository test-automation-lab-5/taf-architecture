package businessobjects.pagepatternclasses.decorator.elements.elements;

import businessobjects.pagepatternclasses.decorator.elements.elements.elementsInterface.Label;
import org.openqa.selenium.WebElement;

public class LabelImpl extends AbstractElement implements Label {
    public LabelImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public boolean isPresent() {
        return webElement.isDisplayed();
    }
}
