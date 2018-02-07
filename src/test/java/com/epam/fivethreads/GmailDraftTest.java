package com.epam.fivethreads;


import com.epam.fivethreads.businessobjects.BasicBO;
import com.epam.fivethreads.businessobjects.DraftsBO;
import com.epam.fivethreads.businessobjects.GmailLogInBO;
import com.epam.fivethreads.businessobjects.SentMailBO;
import com.epam.fivethreads.driverfactory.DriverType;
import com.epam.fivethreads.propmodel.GmailData;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;


public class GmailDraftTest {
    private BasicBO steps;
    private GmailLogInBO gmailLogInBO;
    private DraftsBO draftsBO;
    private SentMailBO sentMailBO;
    private GmailData gmailData;

  @BeforeMethod(description = "init browser")
    public void setUp() {
       steps = new BasicBO();
        gmailLogInBO = new GmailLogInBO();
        draftsBO = new DraftsBO();
        sentMailBO = new SentMailBO();
        gmailData = new GmailData();
    }

    @Test
    public void draftSentLetterTest() {
        gmailLogInBO.login(gmailData.getUserLogin(), gmailData.getUserPassword());
        //assertTrue(gmailLogInBO.isUserLoggedIn());
        draftsBO.createDraft(gmailData.getMessageSentTo(), gmailData.getMessageSubject(), gmailData.getMessageText());
        assertTrue(draftsBO.isMessageInDrafts(gmailData.getMessageText()));
        sentMailBO.sendMessageFromDrafts(gmailData.getMessageText());
        assertTrue(sentMailBO.isMessageInSent(gmailData.getMessageText()));
    }

    @AfterClass(description = "close browser")
    public void tearDownUserCanLogin() {
        steps.closeBrowser();
    }
}
