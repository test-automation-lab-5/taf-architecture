package com.epam.lab5;

import com.epam.lab5.businessobjects.*;
import com.epam.lab5.driver.DriverFactory;
import com.epam.lab5.testdata.properties.DriverDataReader;
import com.epam.lab5.testdata.xml.ObjectDataTransformer;
import com.epam.lab5.testdata.xml.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailTest {

    @DataProvider(name="testData", parallel=true)
    public Object[][] testData(){
        return ObjectDataTransformer.getListObjectsData();
        };

    @Test(dataProvider = "testData")
    public void gmailTest(String eMail,String password) throws IOException {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get(DriverDataReader.getMailLink());

        LoginBO loginBO = new LoginBO(driver);
        InboxBO inboxBO = new InboxBO(driver);
        ComposeBO composeBO = new ComposeBO(driver);
        DraftsBO draftsBO = new DraftsBO(driver);
        TestDataReader testDataReader=new TestDataReader();

        loginBO.login(eMail,password);
        inboxBO.openComposeWindow();
        composeBO.composeMail(eMail);
        draftsBO.openDrafts();

        assertEquals(testDataReader.getSubjectFieldValue(), draftsBO.getDraftMailSubject());
        draftsBO.openDraftMailWithSubject();
        composeBO.sendMail();
        assertTrue(draftsBO.isElementDisplayed());
        DriverFactory.getInstance().closeDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().closeDriver();
    }

}
