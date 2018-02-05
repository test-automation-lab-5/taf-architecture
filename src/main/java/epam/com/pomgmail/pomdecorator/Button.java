package epam.com.pomgmail.pomdecorator;

import org.openqa.selenium.WebElement;

public class Button implements Element {

    protected WebElement wrapElement;

    protected Button(WebElement wrappedElement) {
        this.wrapElement = wrappedElement;
    }

    public void click() {
        wrapElement.click();
    }

    public boolean isDisplayed() {
        return wrapElement.isDisplayed();
    }
}
