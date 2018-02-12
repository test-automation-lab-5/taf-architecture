package com.epam.pageobject;

import com.epam.decorator.Button;
import com.epam.decorator.TextInput;
import org.openqa.selenium.support.FindBy;

import static com.epam.datasource.Constants.*;


public class GmailLoginPage extends  AbstractPage {


    @FindBy(xpath = "//input[@id='identifierId']")
    private TextInput gmailAddress;


    @FindBy(id = "identifierNext")
    private Button addressNext;


    @FindBy(xpath = "//input[@name='password']")
    private TextInput gmailPassword;


    @FindBy(id = "passwordNext")
    private Button passwordNext;


    @FindBy(css = "a[class='WaidBe']")
    private Button gmailLogo;


    public void openInitialPage () {
        openPage(INITIAL_PAGE_URL);
    }

    public void setGmailAddress(String addressInput){

        waitUntilVisible(gmailAddress);
        gmailAddress.enterText(addressInput);

    }

    public void pressAddressNextButton (){

        waitUntilBeClickable(addressNext);
        addressNext.clickOn();

    }


    public void setGmailPassword(String passwordInput){

        waitUntilVisible(gmailPassword);
        gmailPassword.enterText(passwordInput);

    }

    public void pressPasswordNextButton (){

        waitUntilBeClickable(passwordNext);
        passwordNext.clickOn();

    }

    public void goToGmail (){

        waitUntilBeClickable(gmailLogo);
        gmailLogo.clickOn();

    }

    public String getGmailTitle (){

        waitUntilTitle(HOME_TITLE);
        return getTitle();
    }

}
