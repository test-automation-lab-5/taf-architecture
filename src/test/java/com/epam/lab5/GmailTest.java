package com.epam.lab5;

import com.epam.lab5.businessobjects.*;
import com.epam.lab5.driver.Driver;
import com.epam.lab5.testdata.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class GmailTest {

    private WebDriver driver;
    private LoginBO loginBO;
    private InboxBO inboxBO;
    private ComposeBO composeBO;
    private DraftsBO draftsBO;
    private TestDataReader testDataReader;

    @BeforeMethod
    public void setUp() throws IOException {
        driver= Driver.getDriver();
        loginBO = new LoginBO(driver);
        inboxBO = new InboxBO(driver);
        composeBO = new ComposeBO(driver);
        draftsBO = new DraftsBO(driver);
        testDataReader=new TestDataReader();
    }

    @Parameters({"email","password"})
    @Test
    public void gmailTest(String email, String password) throws IOException {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        loginBO.login(email, password);
        inboxBO.openComposeWindow();
        composeBO.composeMail();
        draftsBO.openDrafts();
        assertEquals(testDataReader.getSubjectFieldValue(), draftsBO.getDraftMailSubject());
        draftsBO.openDraftMailWithSubject();
        composeBO.sendMail();
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}
