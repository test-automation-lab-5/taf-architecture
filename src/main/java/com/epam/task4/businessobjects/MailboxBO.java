package com.epam.task4.businessobjects;

import com.epam.task4.businessobjects.pageobjects.MailBoxPage;
import com.epam.task4.testdata.TestData;

import java.util.List;

public class MailboxBO {
    public List<String> deleteFirstNMailsFromCurrentPool(TestData testData) {
        MailBoxPage mailboxPage = new MailBoxPage();
        mailboxPage.waitMailboxPageLoad();
        List<String> deletedIdList = mailboxPage.getIdsOfFirstNMailsFromCurrentPool(testData.getElementsCount());
        mailboxPage
                .checkFirstNCheckboxesFromCurrentPool(testData.getElementsCount())
                .clickVisibleDeleteButton();
        return deletedIdList;
    }

    public MailboxBO undoAction() {
        new MailBoxPage().clickUndoLink();
        return this;
    }

    public boolean verifyMessageRestoration(List<String> idsOfElementsToBeRestored) {
        new MailBoxPage().waitMessageBeRestored(idsOfElementsToBeRestored);
        return true;
    }
}
