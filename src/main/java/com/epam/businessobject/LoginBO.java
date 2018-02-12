package com.epam.businessobject;

import com.epam.pageobject.GmailLoginPage;
import org.apache.log4j.Logger;

public class LoginBO {

    private static final Logger LOG = Logger.getLogger(LoginBO.class);

    private GmailLoginPage gmailLoginPage;

    public LoginBO() {
        gmailLoginPage = new GmailLoginPage();
    }

    public void logIn(String login, String password) {

        gmailLoginPage.openInitialPage();
        gmailLoginPage.setGmailAddress(login);
        gmailLoginPage.pressAddressNextButton();
        gmailLoginPage.setGmailPassword(password);
        gmailLoginPage.pressPasswordNextButton();
        gmailLoginPage.goToGmail();

    }

    public String getActualGmailTitle() {

        String title = gmailLoginPage.getGmailTitle();
        LOG.info(title);
        return title;

    }

}
