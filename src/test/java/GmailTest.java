import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagepatternclasses.GmailPage;
import pagepatternclasses.LoginPage;
import properties.AcountData;
import properties.WebDriverProp;
import testdata.LetterData;
import testdata.LetterDataUnMarshaller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmailTest {
    private static WebDriver driver;
    private AcountData acountData;
    private LetterData letterData;


    @BeforeClass
    public void setUpDriver() throws IOException {
        WebDriverProp webDriverProp = new WebDriverProp();
        letterData = LetterDataUnMarshaller.unmarsaller();
        acountData = new AcountData();
        System.setProperty(webDriverProp.chromeDriver(), webDriverProp.readUrl());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testGmail() throws IOException {
        driver.get(acountData.getGmaiUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginGmail(acountData.getUserName());
        loginPage.setPasswordInput(acountData.getUserPassword(), driver);
        loginPage.openGmailPage();

        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.sendLetter(letterData.getSentTo(), letterData.getSubject(), letterData.getMessage());
        gmailPage.getSentPage();

        Assert.assertEquals(letterData.getSubject(), gmailPage.getSubject(driver));

        gmailPage.removeLetterFromSend();
        gmailPage.pushDeleteOkButton(driver);
        Assert.assertEquals("The conversation has been moved to the Trash.", gmailPage.getMovedMessage());
    }

    @AfterClass
    public static void closeConnection() {
        driver.close();
        driver.quit();
    }
}
