package epam.com.pomgmaltest.tests;

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
    private List<User> users;

    @BeforeMethod
    public void setUpDriver() {
        model = new ModelProperties();
        model.setProperties();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = InstancePage.getInstance().getDriver();
//        driver.get(model.getUrl());
//        driver.get("https://mail.google.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @DataProvider(name = "authentication", parallel = true)
    public Object[] credentials() {
        try {
            users = ParseXML.unmarshalXML();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Object[]{users.get(0), users.get(1)};//, users.get(2)
    }

    @Test(dataProvider = "authentication", threadPoolSize = 3)
    public void loginAndPasswordTest(User users) throws InterruptedException {
        driver.get("https://mail.google.com");
        LoginBO login = new LoginBO();
        login.typeLoginAndPassword(users.getLogin().trim(), users.getPassword().trim());

        Assert.assertEquals("Gmail", driver.getTitle(), "Title not works.");

        MessageBO message = new MessageBO();
        message.interactionWithMessages(driver);

        Assert.assertTrue(message.verifyImportantMessages(driver), "Letters aren't present in Important.");

        message.deleteCheckedMessages(driver);
        Assert.assertTrue(message.verifyIsMessagesDeleted(driver),"Wasn't deleted.");
    }



//    @AfterMethod
//    public void closeDriver() {
//
//        driver.quit();
//    }
}
