package com.epam.task4.businessobjects;

import com.epam.task4.businessobjects.pageobjects.MailBoxPage;

import java.util.List;

public class MailBoxBO {
    public List<String> deleteFirstNMailsFromCurrentPool(int n) {
        MailBoxPage mailboxPage = new MailBoxPage();
        List<String> deletedIdList = mailboxPage.getIdsOfFirstNMailsFromCurrentPool(n);
        mailboxPage
                .waitMailboxPageLoad()
                .checkFirstNCheckboxesFromCurrentPool(n)
                .clickVisibleDeleteButton();
        return deletedIdList;
    }

    public boolean undoActionAndVerifyRestoration(List<String> idsOfElementsToBeRestored) {
        new MailBoxPage()
                .clickUndoLink()
                .waitMessageBeRestored(idsOfElementsToBeRestored);
        return true;
    }
}
