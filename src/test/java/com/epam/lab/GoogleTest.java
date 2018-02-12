package com.epam.lab;

import com.epam.lab.pages.GmailBO;
import com.epam.lab.pages.GmailMainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {

    private WebDriver webDriver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setupDriver(String browser) {
        webDriver = WebDriverFactory.getInstance( browser );
    }

    @Parameters({"email", "pass"})
    @Test
    public void gmailTest(String email, String pass) {
        GmailBO gmailBO = new GmailBO();
        gmailBO.login( webDriver, email, pass );
        gmailBO.selectEmails( webDriver );
        gmailBO.deleteEmails( webDriver );
        gmailBO.undoDeleting( webDriver );
        GmailMainPage gmailMainPage = new GmailMainPage( webDriver );
        Assert.assertEquals( gmailMainPage.expectedResult( gmailMainPage.firstEmailSubject() ), 1 );
    }

    @AfterMethod
    public final void tearDown() {
        webDriver.quit();
    }
}
