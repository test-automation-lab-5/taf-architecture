package com.epam.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GmailLoginPage extends DefaultPage {

    @FindBy(xpath = "//*[@id='identifierId']")
    private WebElement enterEmailField;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    private WebElement enterEmailNextButton;

    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='passwordNext']//descendant::span")
    private WebElement enterPasswordNextButton;

    @FindBy(xpath = ".//*[@id='gbqfq']")
    private WebElement searchField;


    GmailLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

     void enterEmailClickNextButton(String email) {
        enterEmailField.sendKeys( email );
        enterEmailNextButton.click();
    }

    void enterPasswordClickNextButton(String password) {
        waitToBeClickable(passwordField);
        passwordField.sendKeys( password );
        enterPasswordNextButton.click();
        waitToBeClickable( searchField );
    }


}
