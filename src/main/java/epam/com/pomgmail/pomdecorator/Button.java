package epam.com.pomgmail.pomdecorator;

import epam.com.pomgmail.pomdecorator.AbstractElement;
import epam.com.pomgmail.pomdecorator.Element;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement implements Element {

    public Button(WebElement wrapElement) {
        super(wrapElement);
    }

    public void click() {
        wrapElement.click();
    }

    public boolean isDisplayed() {
        return wrapElement.isDisplayed();
    }
}
