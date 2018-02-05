package epam.com.pomgmaltest.tests;

import epam.com.pomgmail.businessobjects.LoginBO;
import epam.com.pomgmail.businessobjects.MessageBO;
import epam.com.pomgmail.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class POMGmailTest {
    private WebDriver driver;
    private static GmailHomePage homePage;
    ModelProperties model = new ModelProperties();

    @BeforeClass
    public void setUpDriver() {
        model.setProperties();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = InstancePage.getInstance();
        driver.get(model.getUrl());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        homePage = new GmailHomePage();
    }

    @Test
    public void loginAndPasswordTest() throws InterruptedException {
        LoginBO login = new LoginBO();
        login.typeLoginAndPassword(driver);

        Assert.assertEquals("Gmail", driver.getTitle(), "Title not works.");

        MessageBO message = new MessageBO();
        message.interactionWithMessages(driver);

        Assert.assertTrue(message.verifyImportantMessages(driver), "Letters aren't present in Important.");

        message.deleteCheckedMessages(driver);
        Assert.assertTrue(message.verifyIsMessagesDeleted(driver),"Wasn't deleted.");
    }

//    @AfterClass
//    public void closeDriver() {
//
//        driver.quit();
//    }
}
