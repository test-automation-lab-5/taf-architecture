import drivers.DriverObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagepatternclasses.GmailPage;
import pagepatternclasses.LoginPage;
import testdata.JAXBHendler;
import testdata.LetterDataUnMarshaller;
import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.User;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class GmailTest {
    private static WebDriver driver;
    private LetterData letterData;
    private List<User> usersData;

    @BeforeClass
    public void setUpDriver() {
        File usersDataXml = new File("src\\\\main\\\\resources\\\\usersData.xml");
        letterData = LetterDataUnMarshaller.unmarsaller();
        try {
            usersData = JAXBHendler.unmarshal(usersDataXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        driver = DriverObject.getDriver();
    }

    @Test
    public void testGmail() {
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
