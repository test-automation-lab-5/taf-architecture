package com.epam.lab.businessObjects;

import com.epam.lab.decorator.MyButton;
import com.epam.lab.decorator.MyDecorator;
import com.epam.lab.decorator.MyTextInput;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PasswordPage {

    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private MyTextInput passwordInput;

    @FindBy(xpath = "//span[text()='Next']")
    private MyButton nextButton;


    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(new MyDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    public void typePassword(String password) {

        passwordInput.sendKeys(password);
        nextButton.click();
    }


}

