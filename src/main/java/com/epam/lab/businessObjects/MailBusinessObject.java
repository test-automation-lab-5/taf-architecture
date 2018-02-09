package com.epam.lab.businessObjects;

import org.openqa.selenium.WebDriver;


public class MailBusinessObject {

    private MailPage mailPage;


    public MailBusinessObject(WebDriver driver) {
        this.mailPage = new MailPage(driver);
    }


    public void composeWrongMail(String email, String subject, String message) {
        mailPage.typeMessage(email, subject, message);
        mailPage.submitMessage();

    }

    public void composeRightMail(String email) {
        mailPage.typeCorrectMessage(email);
        mailPage.submitMessage();
    }

    public boolean verifyAlertMessage() {
        return mailPage.verifyAlertMessage();
    }

    public void clickAlertMessage() {
        mailPage.clickAlertMessage();
    }

    public String checkMail() {
        return mailPage.checkSentMail();
    }
}
