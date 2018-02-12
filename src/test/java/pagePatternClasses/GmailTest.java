package pagePatternClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailTest {
    private static WebDriver driver;
    private static final String DRIVER_URL = "src\\\\main\\\\resources\\\\chromedriver.exe";
    private static final String URL = "https://accounts.google.com/signin";
    private static final String YOUR_EMAIL = "homeworkbohdan@gmail.com";
    private static final String PASSWORD = "719113719113";
    private static final String SEND_TO = "homeworkbohdan@gmail.com";
    private static final String SUBJECT = "TestFour";
    private static final String MESSAGE = "Test message";

    @BeforeClass
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_URL);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testGmail() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginGmail(YOUR_EMAIL);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getPasswordInput()));
        loginPage.setPasswordInput(PASSWORD);
        loginPage.openGmailPage();

        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.sendLetter(SEND_TO, SUBJECT, MESSAGE);
        gmailPage.getSentPage();

        String messageElement = driver.findElement(By.xpath("//*[@class='bog']//*[text()='"+String.format("%s", SUBJECT)+"']")).getText();
        Assert.assertEquals(SUBJECT, messageElement);

        gmailPage.removeLetterFromSend();
        wait.until(ExpectedConditions.elementToBeClickable(gmailPage.getDeleteOkButton()));
        gmailPage.pushDeleteOkButton();
        Assert.assertEquals("The conversation has been moved to the Trash.", gmailPage.getMovedMessage());
    }
    @AfterClass
    public static void closeConnection(){
        driver.close();
        driver.quit();
    }
}
