import com.epam.unused.TestData;
import com.epam.datasource.Unmarshaler;
import com.epam.businessobject.LoginBO;
import com.epam.businessobject.SendEmailBO;
import com.epam.unused.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailBOTest {


    private static WebDriver driver;


    @BeforeClass
    public static void setUp(){
        driver = DriverSingleton.getInstance();
        driver.get("https://accounts.google.com/signin");


    }

    @Test
    public void testGmail (){
        TestData testData = Unmarshaler.getTestData();
        LoginBO loginBO = new LoginBO();
        loginBO.logIn(testData.getLogin(), testData.getPassword());
        Assert.assertTrue(loginBO.getActualGmailTitle().contains(testData.getLogin().replace("iv", "iv.")));

        SendEmailBO sendEmailBO = new SendEmailBO();
        sendEmailBO.sendMessage((testData.getAddress()).substring(0,3), testData.getSubject(), testData.getBody());
        String expectedError= "Проверьте правильность ввода всех адресов.";
        String actualError = sendEmailBO.processError();
        Assert.assertTrue(actualError.contains(expectedError));

        sendEmailBO.closeMailWindow();
        sendEmailBO.sendMessage(testData.getAddress(), testData.getSubject(), testData.getBody());
        sendEmailBO.verifySendingEmail();

    }

    @AfterClass
    public static void cleanUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
