package edu.epam.seleniumexample;

import edu.epam.seleniumexample.businessobjects.LoginBO;
import edu.epam.seleniumexample.businessobjects.MessageBO;
import edu.epam.seleniumexample.utils.BrowserDriver;
import edu.epam.seleniumexample.utils.UserDataReader;
import edu.epam.seleniumexample.utils.PropertyContainer;
import edu.epam.seleniumexample.utils.testdata.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTest {
    private static Integer MARKED_LETTERS_QUANTITY = 3;
    private static String USERS_LIST_FILE = "src\\test\\resources\\login-list.xml";

    private WebDriver driver;
    private PropertyContainer propertyContainer;

    private User user;

    public SimpleTest() {
    }

    @Factory(dataProvider = "signIn")
    SimpleTest (User user){
        this.user = user;
    }
    @DataProvider(name = "signIn", parallel = true)
    public Object[][] initUsers() {
        Object[][] result = null;
        try {
            List<User> users = UserDataReader.unmarshalXML(USERS_LIST_FILE);
            result = new Object[users.size()][1];
            for (int i = 0; i < users.size(); i++) {
                result[i][0] = users.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @BeforeMethod
    public void init() {
        this.propertyContainer = new PropertyContainer();
        this.propertyContainer.loadProperties();
        System.setProperty(this.propertyContainer.getDriverType(), this.propertyContainer.getDriverPath());
        this.driver = BrowserDriver.getInstance().getDriver();
        this.driver.manage().window().maximize();
        this.driver.get(this.propertyContainer.getStartPage());
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDriver() {
        BrowserDriver.getInstance().quitDriver();
    }

    @Test(threadPoolSize = 3)
    public void mainPageTest() {

        LoginBO businessObject = new LoginBO();
        businessObject.loginUser(user.getLogin(), user.getPassword());

        MessageBO messageBO = new MessageBO();
        messageBO.markInboxLetters(MARKED_LETTERS_QUANTITY);
        List<String> inboxMarkedLetterTitles = messageBO.getInboxMarkedTitles();
        messageBO.clickImportantLink();

        List<String> importantBoxTitles = messageBO.findImportandTitles();
        Assert.assertEquals(importantBoxTitles, inboxMarkedLetterTitles);

        //Delete part
        messageBO.checkImportantBoxLetters();
        messageBO.deleteCheckedLetters();

        messageBO.clickInboxLink();
        List<String> inboxLetterTitlesAfterDelete = messageBO.getInboxTitles();
        Assert.assertFalse(inboxLetterTitlesAfterDelete.containsAll(importantBoxTitles));

//        messageBO.openTrash();
//        messageBO.selectAll();
//        messageBO.moveSelectedLettersToInbox();
    }
}
