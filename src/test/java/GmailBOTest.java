import com.epam.DriverProperties;
import com.epam.TestData;
import com.epam.Unmarshaler;
import com.epam.businessobject.LoginBO;
import com.epam.businessobject.SendEmailBO;
import com.epam.pageobject.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailBOTest {

    private static WebDriver driver;


    @BeforeClass
    public static void setUp(){
        DriverProperties driverProperties = new DriverProperties();
        System.setProperty(driverProperties.getChromeDriver(), driverProperties.getUrl());
        driver = DriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");


    }

    @Test
    public void testGmail (){
        TestData testData = Unmarshaler.getTestData();
        LoginBO loginBO = new LoginBO(driver);
        loginBO.logIn(testData.getLogin(), testData.getPassword());
        String title = loginBO.getTitle(driver);
        Assert.assertTrue(title.contains(testData.getLogin().replace("iv", "iv.")));

        SendEmailBO sendEmailBO = new SendEmailBO(driver);
        sendEmailBO.sendMessage((testData.getAddress()).substring(0,3), testData.getSubject(), testData.getBody());
        String expectedError= "Проверьте правильность ввода всех адресов.";
        String actualError = sendEmailBO.processError();
        Assert.assertTrue(actualError.contains(expectedError));

        sendEmailBO.closeMailWindow(driver);
        sendEmailBO.sendMessage(testData.getAddress(), testData.getSubject(), testData.getBody());
        sendEmailBO.verifySendingEmail();

    }

    @AfterClass
    public static void cleanUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }

    }
}
