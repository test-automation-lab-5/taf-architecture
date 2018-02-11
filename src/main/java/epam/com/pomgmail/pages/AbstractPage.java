package epam.com.pomgmail.pages;

import epam.com.pomgmail.pomdecorator.InitElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class AbstractPage {
    private WebDriver driver;

    AbstractPage(){
        driver = CreateDriver.getInstance().getDriver();
        InitElements.initElements(driver, this);
    }
}
