package com.epam.task2.businessobjects;

import com.epam.task2.businessobjects.pageobjects.MailboxPage;

import java.util.List;

public class MailsManipulationBO {
    public List<String> deleteFirstNMailsFromCurrentPool(int n) {
        MailboxPage mailboxPage = new MailboxPage();
        List<String> deletedIdList = mailboxPage.getIdsOfFirstNMailsFromCurrentPool(n);
        mailboxPage
                .waitMailboxPageLoad()
                .checkFirstNCheckboxesFromCurrentPool(n)
                .clickVisibleDeleteButton();
        return deletedIdList;
    }

    public boolean undoActionAndVerifyRestoration(List<String> idsOfElementsToBeRestored) {
        new MailboxPage()
                .clickUndoLink()
                .waitMessageBeRestored(idsOfElementsToBeRestored);
        return true;
    }
}
