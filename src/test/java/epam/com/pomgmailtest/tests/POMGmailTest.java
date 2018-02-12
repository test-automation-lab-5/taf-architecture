package epam.com.pomgmailtest.tests;

import epam.com.pomgmail.businessobjects.LoginBO;
import epam.com.pomgmail.businessobjects.MessageBO;
import epam.com.pomgmail.jaxb.RetrieveUsersData;
import epam.com.pomgmail.jaxb.User;
import epam.com.pomgmail.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class POMGmailTest {
    private WebDriver driver;
    private ModelProperties model;
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
        driver = CreateDriver.getInstance().getDriver();
        driver.get(model.getUrl());
    }

    @DataProvider(name = "authentication", parallel = true)
    public static Object[][] credentials() {
        users = RetrieveUsersData.getXMLUsersComponent();

        Object[][] result = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++)
            result[i][0] = users.get(i);
        return result;
    }

    @Test( threadPoolSize = 3)
    public void loginAndPasswordTest() throws InterruptedException {
        LoginBO login = new LoginBO();
        login.login(dataUsers);

        Assert.assertEquals( driver.getTitle(), "Gmail", "Title not works.");

        MessageBO message = new MessageBO();
        message.setMessagesImportant();
        message.checkImportantMessages();

        Assert.assertTrue(message.isMessagesPresentInImportant(), "Letters aren't present in Important.");

        message.deleteCheckedMessages();
        Assert.assertTrue(message.isMessagesDeleted(),"Wasn't deleted.");
    }

    @AfterMethod
    public void closeDriver() {

        CreateDriver.getInstance().quitDriver();
    }
}
