package com.epam.lab.facadetask.decorator.bo.pages;

import com.epam.lab.facadetask.decorator.handler.CustomPageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends AbstractPage {

    @FindBy(xpath="//input[@id='identifierId']")
    private WebElement emailInput;
    @FindBy(id = "identifierNext")
    private WebElement emailNext;
    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(id = "passwordNext")
    private WebElement passwordNext;
    @FindBy(className="WaidBe")
    private WebElement gmailPage;

    public LoginPage()  {
        super(new CustomPageFactory());
    }

    public void login(String email){
        emailInput.sendKeys(email);
        emailNext.click();
    }


    public void setPassword(String pass){
        waitToBeClickable(passwordInput);
        passwordInput.sendKeys(pass);
        passwordNext.click();
    }

    public void openGmail(){
        gmailPage.click();
    }

    public WebElement getEmailInput(){
        return emailInput;
    }

    public WebElement getEmailNext() {
        return emailNext;
    }

    public WebElement getGmailPage() {
        return gmailPage;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getPasswordNext() {
        return passwordNext;
    }
}
