import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagepatternclasses.GmailPage;
import pagepatternclasses.LoginPage;
import properties.WebDriverProp;
import testdata.JAXBHendler;
import testdata.LetterDataUnMarshaller;
import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.User;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GmailTest {
    private static WebDriver driver;
    private LetterData letterData;
    private List<User> usersData;

    @BeforeClass
    public void setUpDriver() throws IOException, JAXBException {
        File usersDataXml = new File("src\\\\main\\\\resources\\\\usersData.xml");
        WebDriverProp webDriverProp = new WebDriverProp();
        letterData = LetterDataUnMarshaller.unmarsaller();
        usersData = JAXBHendler.unmarshal(usersDataXml);
        System.setProperty(webDriverProp.chromeDriver(), webDriverProp.readUrl());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testGmail() throws IOException {
        driver.get(usersData.get(0).getLoginPage());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginGmail(usersData.get(0).getLogin());
        loginPage.setPasswordInput(usersData.get(0).getPassword());
        loginPage.openGmailPage();

        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.sendLetter(letterData.getSentTo(), letterData.getSubject(), letterData.getMessage());

        gmailPage.getSentPage();
        Assert.assertEquals(letterData.getSubject(), gmailPage.getSubject());
        gmailPage.removeLetterFromSend();
        gmailPage.pushDeleteOkButton();
        Assert.assertEquals("The conversation has been moved to the Trash.", gmailPage.getMovedMessage());
    }

    @AfterClass
    public static void closeConnection() {
        driver.close();
        driver.quit();
    }
}
