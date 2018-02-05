package com.epam.businessobject;

import com.epam.pageobject.GmailLoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBO {

    private GmailLoginPage gmailLoginPage;

public LoginBO (WebDriver driver){
    gmailLoginPage = new GmailLoginPage(driver);
}

public void logIn (String login, String password){
    gmailLoginPage.setGmailAddress(login);
    gmailLoginPage.pressAddressNextButton();
    gmailLoginPage.setGmailPassword(password);
    gmailLoginPage.pressPasswordNextButton();
    gmailLoginPage.goToGmail();
}

public String getTitle (WebDriver driver ){
    String title = gmailLoginPage.getTitle(driver);
    System.out.println(title);
    return title;
}

}
