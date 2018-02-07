

import com.epam.lab.DriverFactory;
import com.epam.lab.GlobalConfiguration;
import com.epam.lab.businessObjects.MailBusinessObject;
import com.epam.lab.businessObjects.LoginBusinessObject;
import com.epam.lab.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
   private static WebDriver driver=null;
    private static WebDriverWait wait=null;

    @BeforeMethod
    public static void open() {

        GlobalConfiguration.loadProperties();
        GlobalConfiguration.loadData();
      System.setProperty(com.epam.lab.GlobalConfiguration.NAME_DRIVER, com.epam.lab.GlobalConfiguration.PATH_DRIVER);
      /*  driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);*/
     //   ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
     // driver=SingletonDriver.Initialize();
    //  driver= SingletonDriver.getDriver();


     /*   WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.navigate().to(GlobalConfiguration.URL);*/

      /*  WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.navigate().to(GlobalConfiguration.URL);

*/





   /*

        driver=SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 40);
        driver.navigate().to(GlobalConfiguration.URL);*/
    }
    @DataProvider(name="testData", parallel=true)
    public Object[][] testData(){
        return new Object[][]{
              {"test.iryna.mail@gmail.com", "testmail"},
               {"test.iryna.mail@gmail.com", "testmail"},
                {"test.iryna.mail@gmail.com", "testmail"},
                {"test.iryna.mail@gmail.com", "testmail"},
                {"test.iryna.mail@gmail.com", "testmail"}
              /*  {GlobalConfiguration.MAIL,GlobalConfiguration.PASSWORD},
                {GlobalConfiguration.MAIL1,GlobalConfiguration.PASSWORD1},
                {GlobalConfiguration.MAIL2,GlobalConfiguration.PASSWORD2},
                {GlobalConfiguration.MAIL3,GlobalConfiguration.PASSWORD3},
                {GlobalConfiguration.MAIL4,GlobalConfiguration.PASSWORD4}*/
        };
    }


    @Test(dataProvider = "testData")
  //@Test public void composeMail() {
  public void composeMail(String myEmail, String myPassword) {
          //1.  Implement decorator pattern for your page object controls (Button, Label, TextInput)

        //3.Implement business object layer to keep test layer isolated from page object layer (Use façade design pattern)
       WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.navigate().to(GlobalConfiguration.URL);
        LoginBusinessObject loginBusinessObject = new LoginBusinessObject(driver);
        MailBusinessObject mailBusinessObject=new MailBusinessObject(driver);
        //  1.Open gmail & login
    //******///    driver.navigate().to(GlobalConfiguration.URL);

     //  loginBusinessObject.loginUser(GlobalConfiguration.MAIL,GlobalConfiguration.PASSWORD);
        loginBusinessObject.loginUser(myEmail,myPassword);

             //2,3.Click on compose button Enter incorrect email in “to” field, fill “subject”/”message” fields & press “send” button
       mailBusinessObject.composeWrongMail(GlobalConfiguration.INCORRECT_MAIL, GlobalConfiguration.SUBJECT, GlobalConfiguration.MESSAGE);
        //4.Verify that warning message appears
        assertTrue(mailBusinessObject.verifyAlertMessage());
       mailBusinessObject.clickAlertMessage();

        //5.Click “OK” & enter correct email address & click send
       mailBusinessObject.composeRightMail(GlobalConfiguration.TARGET_MAIL);
        // 6.Verify that message is moved to “Sent mail” folder
       assertEquals(GlobalConfiguration.TARGET_MAIL,mailBusinessObject.checkMail());

   
    }

    @AfterMethod
    public static void close() {
           DriverFactory.getInstance().removeDriver();

    }
}
