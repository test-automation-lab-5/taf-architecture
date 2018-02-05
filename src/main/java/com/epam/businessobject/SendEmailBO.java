package com.epam.businessobject;

import com.epam.pageobject.GmailAlertPage;
import com.epam.pageobject.GmailHomePage;
import org.openqa.selenium.WebDriver;

public class SendEmailBO {

    private GmailHomePage gmailHomePage;
    private GmailAlertPage gmailAlertPage;


    public SendEmailBO(WebDriver driver){
        gmailHomePage = new GmailHomePage(driver);
        gmailAlertPage = new GmailAlertPage(driver);
    }

    public void sendMessage (String address, String subject, String body){

        gmailHomePage.pressComposeButton();
        gmailHomePage.pressExpandWindow();
        gmailHomePage.setToAddress(address);
        gmailHomePage.setGmailSubject(subject);
        gmailHomePage.setGmailBody(body);
        gmailHomePage.pressSendButton();


    }

    public void closeMailWindow (WebDriver driver){
        gmailHomePage.clickTrashButton(driver);
    }

    public String processError (){
        String actualError= gmailAlertPage.getAlertMessage();
        System.out.println(String.format("Error message: %s", actualError));
        gmailAlertPage.pressOkButton();
        return actualError;
    }

    public void verifySendingEmail (){
        gmailHomePage.goToSentEmails();
        gmailHomePage.verifySendingEmail();
    }
}
