package com.epam.fivethreads;


import com.epam.fivethreads.businessobjects.BasicBO;
import com.epam.fivethreads.businessobjects.DraftsBO;
import com.epam.fivethreads.businessobjects.GmailLogInBO;
import com.epam.fivethreads.businessobjects.SentMailBO;
import com.epam.fivethreads.propmodel.GmailData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class MultithreadGmailLoginTest {
    private BasicBO steps;
    private GmailLogInBO gmailLogInBO;
    private DraftsBO draftsBO;
    private SentMailBO sentMailBO;
    private GmailData gmailData;


   @DataProvider(parallel = true)
    public Object[][]initUsers(){
        return new Object[][]{
                {"ForHometaskTest@gmail.com","12345aKids"},
                {"ForHometaskTest1@gmail.com","12345aKids"}
        };
    }
    @Test(dataProvider="initUsers")
    public void threadsTesting(String login, String password){
        steps = new BasicBO();
        gmailLogInBO = new GmailLogInBO();
        gmailLogInBO.login(login,password);
        steps.closeBrowser();
        assertTrue(gmailLogInBO.isUserLoggedIn());
    }

    @AfterClass(description = "close browser")
    public void tearDownUserCanLogin() {
        steps.closeBrowser();
    }




}
