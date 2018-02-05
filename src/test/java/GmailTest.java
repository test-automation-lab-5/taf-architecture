import businessobjects.GmailBO;
import drivers.DriverObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testdata.JAXBHendler;
import testdata.LetterDataUnMarshaller;
import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.User;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class GmailTest {
    private static final String GMAILURL = "https://accounts.google.com/signin";
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
        driver.get(GMAILURL);
        GmailBO gmailBO = new GmailBO();
        gmailBO.login(usersData.get(0).getLogin(), usersData.get(0).getPassword());
        gmailBO.sendMail(letterData.getSentTo(), letterData.getSubject(), letterData.getMessage());
        Assert.assertEquals(letterData.getSubject(), gmailBO.getSubject());
        gmailBO.moveLetter();
        Assert.assertEquals("The conversation has been moved to the Trash.", gmailBO.getMovedMessage());
    }

    @AfterClass
    public static void closeConnection() {
        if (!Objects.isNull(driver)) {
            driver.close();
            driver.quit();
        }
    }
}
