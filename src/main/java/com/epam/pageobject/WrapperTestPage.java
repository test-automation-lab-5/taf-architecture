package com.epam.pageobject;

import com.epam.decorator.ElementFactory;
import com.epam.decorator.IButton;
import com.epam.decorator.ITextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperTestPage {

    WebDriverWait wait;


    public WrapperTestPage (WebDriver driver) {
        ElementFactory.initElements(driver, WrapperTestPage.class);
        wait = new WebDriverWait(driver,30);
    }

    /*public static WrapperTestPage initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, WrapperTestPage.class);
    }*/


    @FindBy(xpath = "//input[@id='identifierId']")
    private ITextInput gmailAddress;


    @FindBy(id = "identifierNext")
    private IButton addressNext;


    @FindBy(xpath = "//input[@name='password']")
    private ITextInput gmailPassword;


    @FindBy(id = "passwordNext")
    private IButton passwordNext;


    @FindBy(css = "a[class='WaidBe']")
    private IButton gmailLogo;


    public void setGmailAddress(String addressInput){

        gmailAddress.enterText(addressInput);

    }

    public void pressAddressNextButton (){

        addressNext.clickOn();

    }


    public void setGmailPassword(String passwordInput){

        gmailPassword.enterText(passwordInput);

    }

    public void pressPasswordNextButton (){

        wait.until(ExpectedConditions.elementToBeClickable(passwordNext));
        passwordNext.clickOn();

    }

    public void goToGmail (){

        gmailLogo.clickOn();

    }

    public String getTitle (WebDriver driver){

        wait.until(ExpectedConditions.titleContains("olenayurkiv.2017@gmail.com"));
        return driver.getTitle();
    }

}
