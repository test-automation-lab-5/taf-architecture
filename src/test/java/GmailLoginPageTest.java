import com.epam.DriverProperties;
import com.epam.pageobject.DriverSingleton;
import com.epam.pageobject.GmailAlertPage;
import com.epam.pageobject.GmailHomePage;
import com.epam.pageobject.GmailLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*public class GmailLoginPageTest {
    private static WebDriver driver;


    @BeforeClass
    public static void setUp(){
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        DriverProperties driverProperties = new DriverProperties();
        System.setProperty(driverProperties.getChromeDriver(), driverProperties.getUrl());
        driver = DriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");

    }




    @Test(priority=0)
    public void testLogin () {


        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);

        String gmailAddress = "olenayurkiv2017@gmail.com";
        gmailLoginPage.setGmailAddress(gmailAddress);
        gmailLoginPage.pressAddressNextButton();
        String gmailPassword = "0633787Mm";
        gmailLoginPage.setGmailPassword(gmailPassword);
        gmailLoginPage.pressPasswordNextButton();
        gmailLoginPage.goToGmail();
        String title = gmailLoginPage.getTitle(driver);
        //String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("olenayurkiv.2017@gmail.com"));

    }

    @Test(priority=1)
    public void sendWrongEmail () {
        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        String emailSubject="Email subject";
        String toMailIdWrong ="ole";
        //String toMailId ="olenayurkiv2017@gmail.com";
        String mailBody ="Mailbody";
        gmailHomePage.pressComposeButton();
        gmailHomePage.pressExpandWindow();
        gmailHomePage.setToAddress(toMailIdWrong);
        gmailHomePage.setGmailSubject(emailSubject);
        gmailHomePage.setGmailBody(mailBody);
        gmailHomePage.pressSendButton();


        GmailAlertPage gmailAlertPage = new GmailAlertPage(driver);
        String expectedError= "Проверьте правильность ввода всех адресов.";
        String actualError= gmailAlertPage.getAlertMessage();
        System.out.println(String.format("Error message: %s", actualError));
        gmailAlertPage.pressOkButton();
        Assert.assertTrue(actualError.contains(expectedError));


    }

    @Test(priority=2)
    public void sendValidEmail () {
        GmailHomePage gmailHomePage   = new GmailHomePage(driver);
        gmailHomePage.clickTrashButton(driver);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click()", gmailHomePage.trashButton);
        String emailSubject="Email subject";
        String toMailId ="olenayurkiv2017@gmail.com";
        String mailBody ="Mailbody";

        gmailHomePage.pressComposeButton();
        gmailHomePage.pressExpandWindow();
        gmailHomePage.setToAddress(toMailId);
        gmailHomePage.setGmailSubject(emailSubject);
        gmailHomePage.setGmailBody(mailBody);
        gmailHomePage.pressSendButton();

        gmailHomePage.goToSentEmails();
        gmailHomePage.verifySendingEmail();



    }

    @AfterClass
    public static void cleanUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }

    }
}*/
