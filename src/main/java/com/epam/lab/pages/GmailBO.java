package com.epam.lab.pages;

import com.epam.lab.ReadProperties;
import org.openqa.selenium.WebDriver;

import static com.epam.lab.ReadProperties.readDataFile;

public class GmailBO {
    private ReadProperties data = new ReadProperties();
    GmailMainPage gmailMainPage;

   public GmailBO(WebDriver webDriver){
        gmailMainPage = new GmailMainPage( webDriver );
    }

    public void login(WebDriver webDriver, String email, String pass ) {
        readDataFile( data );
        webDriver.get( data.getUrl() );
        webDriver.manage().window().maximize();
        GmailLoginPage gmailLoginPage = new GmailLoginPage( webDriver );
        gmailLoginPage.enterEmail( email );
        gmailLoginPage.clickNextButton();
        gmailLoginPage.enterPassword( pass );
        gmailLoginPage.clickLoginButton();

    }

    public String expectedUrl() {
        readDataFile( data );
        return data.getUrlLoginPassed();

    }

    public void selectEmails( ) {
        readDataFile( data );

        gmailMainPage.selectCheckboxes( 3 );
    }

    public void deleteEmails() {

        gmailMainPage.deleteEmails();
    }

    public void undoDeleting( ) {

        gmailMainPage.undoDeleting();
        gmailMainPage.waitForDeleteCanceledMessage();
    }


}
