package com.epam.lab5.pageobjects;

import com.epam.lab5.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class AbstractPage {
     WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(
                new DefaultElementLocatorFactory(driver)
        ), this);
    }

}
