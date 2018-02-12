package com.epam.businessobject;

import com.epam.pageobject.GmailErrorPage;
import com.epam.pageobject.GmailHomePage;
import org.apache.log4j.Logger;

import static  com.epam.datasource.Constants.*;


public class SendEmailBO {

    private static final Logger LOG = Logger.getLogger(SendEmailBO.class);

    private GmailHomePage gmailHomePage;
    private GmailErrorPage gmailErrorPage;


    public SendEmailBO(){
        gmailHomePage = new GmailHomePage();
        gmailErrorPage = new GmailErrorPage();
    }

    public void sendMessage (String address, String subject, String body){

        gmailHomePage.pressComposeButton();
        gmailHomePage.pressExpandWindow();
        gmailHomePage.setToAddress(address);
        gmailHomePage.setGmailSubject(subject);
        gmailHomePage.setGmailBody(body);
        gmailHomePage.pressSendButton();


    }

    public void closeMailWindow (){
        gmailHomePage.clickTrashButton();
    }

    public String processError (){

        String actualError= gmailErrorPage.getAlertMessage();
        LOG.info(String.format("Error message: %s", actualError));
        gmailErrorPage.pressOkButton();
        return actualError;

    }

    public boolean verifySendingEmail (){

        Boolean result;
        gmailHomePage.goToSentEmails();
        if (gmailHomePage.checkIfWasSent()){
            result = true;
            LOG.info(String.format(" %s, %d", SUCCESS_MESSAGE, Thread.currentThread().getId()));
        } else {
            result = false;
            LOG.info(String.format(" %s, %d", FAIL_MESSAGE, Thread.currentThread().getId()));
        }
        return result;
        }

    }


