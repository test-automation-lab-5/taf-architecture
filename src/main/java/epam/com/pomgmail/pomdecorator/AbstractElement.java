package epam.com.pomgmail.pomdecorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractElement implements Element {
    WebElement wrapElement;

    public AbstractElement(WebElement wrapElement) {

        this.wrapElement = wrapElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrapElement.isDisplayed();
    }
}
