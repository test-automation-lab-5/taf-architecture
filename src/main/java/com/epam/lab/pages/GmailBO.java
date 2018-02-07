package com.epam.lab.pages;

import com.epam.lab.ReadProperties;
import org.openqa.selenium.WebDriver;
import static com.epam.lab.ReadProperties.readDataFile;

public class GmailBO {
    private ReadProperties data = new ReadProperties();

    public void login(WebDriver webDriver, String email, String pass) {
        readDataFile(data);
        webDriver.get( data.getUrl() );
        webDriver.manage().window().maximize();

        GmailLoginPage gmailLoginPage = new GmailLoginPage( webDriver );
        gmailLoginPage.enterEmailClickNextButton( email );//data.getEmail()
        gmailLoginPage.enterPasswordClickNextButton( pass );// data.getPassword()

    }
    public String expectedUrl(){
        readDataFile( data );
      return  data.getUrlLoginPassed();

    }

    public void deleteEmails(WebDriver webDriver) {

        readDataFile(data);

        GmailMainPage gmailMainPage = new GmailMainPage( webDriver );
        gmailMainPage.selectCheckboxes( 3 );

        gmailMainPage.deleteEmails();
        gmailMainPage.undoDeleting();
        gmailMainPage.waitForDeleteCanceledMessage();

    }


}
