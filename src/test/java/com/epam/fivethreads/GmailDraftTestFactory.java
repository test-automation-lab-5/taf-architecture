package com.epam.fivethreads;


import com.epam.fivethreads.businessobjects.DraftsBO;
import com.epam.fivethreads.businessobjects.GmailLogInBO;
import com.epam.fivethreads.data.handlers.LattersDataCreator;
import com.epam.fivethreads.data.handlers.UsersDataReader;
import com.epam.fivethreads.data.model.Letter;
import com.epam.fivethreads.data.model.Letters;
import com.epam.fivethreads.data.model.User;
import com.epam.fivethreads.data.model.Users;
import com.epam.fivethreads.data.utils.Data2ArrayConverter;
import com.epam.fivethreads.driver.SafeThreadDriverCreator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class GmailDraftTestFactory {
    private User user;
    private Letter letter;


    public GmailDraftTestFactory() {
    }

    @Factory(dataProvider = "currentDataProvider")
    public GmailDraftTestFactory(User user, Letter letter) {
        this.user = user;
        this.letter = letter;
    }

    @DataProvider(name = "currentDataProvider",parallel = true)
    public Object[][] initUsers() {
        Users users = new UsersDataReader().getUsers();
        Letters letters = new LattersDataCreator().getLetters();
        return Data2ArrayConverter.getData(users, letters);
    }

    @Test
    public void draftSentLetterTest() {

        GmailLogInBO gmailLogInBO = new GmailLogInBO();
        gmailLogInBO.openLoginPage();
        gmailLogInBO.login(user);
        System.out.println(user.toString());
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
