import main.driver.Driver;
import main.businessobjects.*;
import main.domparser.xmlmodels.*;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.*;
import properties.DataProp;

public class FactoryTest {
    private User user;
    private MessageData messageData;
    private DataProp properties;
    private LoginBusinessObject loginBusinessObject;
    private LetterWindowBusinessObject letterWindowBusinessObject;
    private DraftsBusinessObject draftsBusinessObject;

    @Factory(dataProviderClass = DataForTestProvider.class, dataProvider = "getData")
    public FactoryTest(User user, MessageData data) {
        this.user = user;
        this.messageData = data;
    }

    @BeforeMethod
    public void setUp() {
        properties = new DataProp();
        loginBusinessObject = new LoginBusinessObject();
        letterWindowBusinessObject = new LetterWindowBusinessObject();
        draftsBusinessObject = new DraftsBusinessObject();
    }

    @AfterMethod
    public void after() {
        Driver.destroy();
    }

    @Test
    public void testGmail() {
        Driver.getDriver().get(properties.getURL());

        String expectedSubject = messageData.generateSubject();//expected subject

        loginBusinessObject.login(user);
        letterWindowBusinessObject.composeLetter(messageData, expectedSubject);
        draftsBusinessObject.openDrafts(expectedSubject);

        String actualSubject = letterWindowBusinessObject.getSubject();//actual subject

        letterWindowBusinessObject.sendLetter();
        draftsBusinessObject.logOut();

        Assert.assertEquals(actualSubject, expectedSubject);
    }
}
