package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.AbstractElement;
import businessobjects.pagepatternclasses.decorator.elements.elements.MyElementFactory;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import drivers.DriverObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    private WebDriver driver;
    private MyElementFactory elementFactory = new MyElementFactory();

    protected AbstractPage(MyPageFactory myPageFactory) {
        driver = DriverObject.getDriver();
        myPageFactory.initElements(driver, this);
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, 25));
    }

    protected AbstractElement waitUntilBeClickableAbstract(AbstractElement element) {
        return elementFactory.create(element.getClass(), getWait().until(ExpectedConditions.elementToBeClickable(element.getWebElement())));
    }
}