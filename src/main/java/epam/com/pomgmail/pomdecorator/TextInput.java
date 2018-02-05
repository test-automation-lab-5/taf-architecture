package epam.com.pomgmail.pomdecorator;

import org.openqa.selenium.WebElement;

public class TextInput implements Element {

    protected WebElement wrapElement;

    protected TextInput(WebElement wrappedElement) {
        this.wrapElement = wrappedElement;
    }

    public void sendKeys(String text) {
        wrapElement.sendKeys(text);
    }

    public boolean isDisplayed() {
        return wrapElement.isDisplayed();
    }
}
