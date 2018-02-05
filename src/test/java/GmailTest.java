import main.Driver;
import main.LetterWindowPageBusinessObject;
import main.businessobjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import properties.DataProp;

import java.io.IOException;

public class GmailTest {
    private WebDriver driver;
    private LoginPageBusinessObject loginPageBusinessObject;
    private DraftsBusinessObject draftsPageBusinessObject;
    private LetterWindowPageBusinessObject letterWindowPageBusinessObject;
    private DataProp dataProp;

    @BeforeMethod
    public void setUp() throws IOException {
        DataBusinessObject dataBusinessObject = new DataBusinessObject();
        dataProp = new DataProp();
        dataBusinessObject.setDriver();
        driver = Driver.getInstance();

        loginPageBusinessObject = new LoginPageBusinessObject();
        letterWindowPageBusinessObject = new LetterWindowPageBusinessObject();
        draftsPageBusinessObject = new DraftsBusinessObject();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sendLetterFromDraftsTest() {
        loginPageBusinessObject.login(dataProp);
        letterWindowPageBusinessObject.composeLetter(dataProp);
        try {
            draftsPageBusinessObject.openDrafts(dataProp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        letterWindowPageBusinessObject.sendLetter();

        Assert.assertTrue(letterWindowPageBusinessObject.isTheSame());
    }
}
