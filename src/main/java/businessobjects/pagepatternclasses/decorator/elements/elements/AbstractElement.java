package businessobjects.pagepatternclasses.decorator.elements.elements;

import org.openqa.selenium.WebElement;

public class AbstractElement {
    protected WebElement webElement;

    public AbstractElement(WebElement webElement) {
        this.webElement = webElement;
    }
    public String getAttribute(String s){
        return webElement.getAttribute(s);
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
