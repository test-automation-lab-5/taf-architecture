package com.epam.lab.businessObjects;

import com.epam.lab.decorator.MyButton;
import com.epam.lab.decorator.MyDecorator;
import com.epam.lab.decorator.MyTextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@type=\'email\']")
    private MyTextInput loginInput;

    @FindBy(xpath = "//span[text()='Next']")
    private MyButton nextButton;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new MyDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    public void typeLogin(String login) {


        loginInput.sendKeys(login);
        nextButton.click();

    }


}
