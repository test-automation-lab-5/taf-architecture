import main.Driver;
import main.businessobjects.DraftsBusinessObject;
import main.businessobjects.LetterWindowPageBusinessObject;
import main.businessobjects.LoginPageBusinessObject;
import main.domparser.xmlmodels.MessageData;
import main.domparser.xmlmodels.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTest {
    private User user;
    private MessageData messageData;

    @Factory(dataProviderClass = GmailTest.class, dataProvider = "getData")
    public FactoryTest(User user, MessageData data) {
        this.user = user;
        this.messageData = data;
    }

    @Test
    public void testGmail() {
        LoginPageBusinessObject loginPageBusinessObject = new LoginPageBusinessObject();
        LetterWindowPageBusinessObject letterWindowPageBusinessObject = new LetterWindowPageBusinessObject();
        DraftsBusinessObject draftsBusinessObject = new DraftsBusinessObject();

        Driver.getDriver().get("https://gmail.com");

        String expectedSubject = messageData.generateSubject();//expected subject

        loginPageBusinessObject.login(user);
        letterWindowPageBusinessObject.composeLetter(messageData, expectedSubject);
        draftsBusinessObject.openDrafts(expectedSubject);

        String actualSubject = letterWindowPageBusinessObject.getSubject();//actual subject

        letterWindowPageBusinessObject.sendLetter();

        draftsBusinessObject.openUserAlert();

        Assert.assertEquals(actualSubject, expectedSubject);
    }

    @AfterMethod
    public void after() {
        Driver.destroy();
    }
}
