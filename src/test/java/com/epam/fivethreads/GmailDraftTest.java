package com.epam.fivethreads;


import com.epam.fivethreads.businessobjects.DraftsBO;
import com.epam.fivethreads.businessobjects.GmailLogInBO;
import com.epam.fivethreads.data.model.*;
import com.epam.fivethreads.data.utils.Data2ArrayConverter;
import com.epam.fivethreads.data.handlers.LattersDataCreator;
import com.epam.fivethreads.data.handlers.UsersDataReader;
import com.epam.fivethreads.driver.SafeThreadDriverCreator;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;

public class GmailDraftTest {

    @DataProvider(parallel = true)
    public Object[][] initUsers() {
        Users users = new UsersDataReader().getUsers();
        Letters letters = new LattersDataCreator().getLetters();
        return Data2ArrayConverter.getData(users, letters);
    }

    @Test(dataProvider = "initUsers")
    public void draftSentLetterTest(User user, Letter letter) {

        GmailLogInBO gmailLogInBO = new GmailLogInBO();
        gmailLogInBO.openLoginPage();
        gmailLogInBO.login(user);
        assertTrue(gmailLogInBO.isUserLoggedIn());

        DraftsBO draftsBO = new DraftsBO();
        draftsBO.createDraft(letter);
        draftsBO.openDrafts();
        assertTrue(draftsBO.isMessageInDrafts(letter));

        draftsBO.sendMessageFromDrafts(letter);

        draftsBO.openSentMails();
        assertTrue(draftsBO.isMessageInSent(letter));
    }

    @AfterMethod(description = "close browser")
    public void tearDownUserCanLogin() {
       SafeThreadDriverCreator.getInstance().removeDriver();

    }


}
