import businessobjects.GmailBO;
import drivers.DriverObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.User;

public class FactoryTest {
    private LetterData letterData;
    private User user;


    @Factory(dataProviderClass = GmailTest.class, dataProvider = "getData")
    public FactoryTest(LetterData letterData, User user) {
        this.letterData = letterData;
        this.user = user;
    }

    @Test()
    public void testGmail() {
        GmailBO gmailBO = new GmailBO();
        gmailBO.login(user.getLogin(), user.getPassword());
        gmailBO.sendMail(letterData.getSentTo(), letterData.getSubject(), letterData.getMessage());
        gmailBO.getSentPage();
        Assert.assertEquals(letterData.getSubject(), gmailBO.getSubject(letterData.getSubject()));
        System.out.println("assert");
        gmailBO.moveLetter();
        System.out.println("muve");
        Assert.assertEquals("The conversation has been moved to the Trash.", gmailBO.getMovedMessage());
    }
    @AfterMethod
    public void driverQuit(){
        DriverObject.driverQuit();
    }

}
