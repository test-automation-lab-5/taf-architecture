package com.epam.lab;

import com.epam.lab.pages.GmailBO;
import com.epam.lab.pages.GmailMainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void setupDriver() {
        webDriver = WebDriverFactory.getInstance();
    }

    @Test
    public void gmailTest() throws InterruptedException {
        GmailBO gmailBO = new GmailBO();
        gmailBO.login( webDriver );
        Assert.assertEquals( webDriver.getCurrentUrl(), gmailBO.expectedUrl() );

        gmailBO.deleteEmails( webDriver );

        GmailMainPage gmailMainPage = new GmailMainPage( webDriver );
        Assert.assertEquals(gmailMainPage .expectedResult( gmailMainPage.firstEmailSubject() ), 1 );
    }

    @AfterMethod
    public final void tearDown() {
        webDriver.quit();
    }
}
