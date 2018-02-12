package com.epam.lab5.businessobjects.pageobjects;

import com.epam.lab5.decorator.MyFieldDecorator;
import com.epam.lab5.decorator.elements.PageElement;
import com.epam.lab5.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(new MyFieldDecorator(
                new DefaultElementLocatorFactory(driver)
        ), this);
    }

    public void waitElementBeVisible(PageElement element, int seconds){
        (new WebDriverWait(driver, seconds)).until(ExpectedConditions.visibilityOf(element));
    }

}
