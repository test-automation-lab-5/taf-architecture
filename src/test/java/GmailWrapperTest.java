import com.epam.DriverProperties;
import com.epam.TestData;
import com.epam.Unmarshaler;
import com.epam.businessobject.LoginBO;
import com.epam.businessobject.SendEmailBO;
import com.epam.pageobject.DriverSingleton;
import com.epam.pageobject.WrapperTestPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*public class GmailWrapperTest {

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
        WrapperTestPage wrapperTestPage = new WrapperTestPage(driver);
        wrapperTestPage.setGmailAddress(testData.getLogin());
        wrapperTestPage.pressAddressNextButton();
        wrapperTestPage.setGmailPassword(testData.getPassword());
        wrapperTestPage.pressPasswordNextButton();
        wrapperTestPage.goToGmail();
        String title = wrapperTestPage.getTitle(driver);
        Assert.assertTrue(title.contains(testData.getLogin().replace("iv", "iv.")));

    }

    @AfterClass
    public static void cleanUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }

    }
}*/
