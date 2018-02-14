package com.epam.lab.pages;

import com.epam.lab.elements.Button;
import com.epam.lab.elements.InputField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

class GmailLoginPage extends DefaultPage {

    @FindBy(xpath = "//*[@id='identifierId']")
    private InputField enterEmailField;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    private Button enterEmailNextButton;

    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private InputField passwordField;

    @FindBy(xpath = ".//*[@id='passwordNext']//descendant::span")
    private Button enterPasswordNextButton;

    @FindBy(xpath = ".//*[@id='gbqfq']")
    private InputField searchField;



    GmailLoginPage(WebDriver webDriver) {

        super( webDriver );
        Assert.assertTrue( enterEmailField.isDisplayed() );
    }

    void enterEmail(String email) {
        enterEmailField.sendKeys( email );
    }

    void clickNextButton() {
        enterEmailNextButton.click();
    }

    void enterPassword(String password) {
        waitToBeClickable( passwordField );
        passwordField.sendKeys( password );
    }

    void clickLoginButton() {
        enterPasswordNextButton.click();
        waitToBeClickable( searchField );
    }


}
