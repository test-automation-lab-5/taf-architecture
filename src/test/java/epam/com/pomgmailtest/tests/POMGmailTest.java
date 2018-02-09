package epam.com.pomgmailtest.tests;

import epam.com.pomgmail.businessobjects.LoginBO;
import epam.com.pomgmail.businessobjects.MessageBO;
import epam.com.pomgmail.jaxb.ParseXML;
import epam.com.pomgmail.jaxb.User;
import epam.com.pomgmail.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class POMGmailTest {
    private WebDriver driver;
    ModelProperties model;
    private static List<User> users;
    private User dataUsers;

    POMGmailTest(){

    }

    @Factory( dataProvider = "authentication")
    POMGmailTest(User dataUsers){
        this.dataUsers = dataUsers;
    }

    @BeforeMethod
    public void setUpDriver() {
        model = new ModelProperties();
        model.setProperties();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = InstancePage.getInstance().getDriver();
        driver.get(model.getUrl());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @DataProvider(name = "authentication", parallel = true)
    public static Object[][] credentials() {
        try {
            users = ParseXML.unmarshalXML();
        }catch (Exception e){
            e.printStackTrace();
        }

        Object[][] res = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++)
            res[i][0] = users.get(i);
        return res;
    }

    @Test( threadPoolSize = 3)
    public void loginAndPasswordTest() throws InterruptedException {
        LoginBO login = new LoginBO();
        login.typeLoginAndPassword(dataUsers.getLogin().trim(), dataUsers.getPassword().trim());

        Assert.assertEquals("Gmail", driver.getTitle(), "Title not works.");

        MessageBO message = new MessageBO();
        message.interactionWithMessages(driver);
        message.checkImportantMessages(driver);

        Assert.assertTrue(message.verifyImportantMessages(driver), "Letters aren't present in Important.");

        message.deleteCheckedMessages(driver);
        Assert.assertTrue(message.verifyIsMessagesDeleted(driver),"Wasn't deleted.");
    }



    @AfterMethod
    public void closeDriver() {

        InstancePage.getInstance().quitDriver();
    }
}
