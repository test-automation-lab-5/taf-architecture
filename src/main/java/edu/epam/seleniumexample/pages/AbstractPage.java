package edu.epam.seleniumexample.pages;

import edu.epam.seleniumexample.utils.BrowserDriver;
import edu.epam.seleniumexample.utils.PropertyContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        driver = BrowserDriver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

}
