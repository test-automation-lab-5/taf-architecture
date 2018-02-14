package com.epam.lab;

import com.epam.lab.pages.GmailBO;
import com.epam.lab.pages.GmailMainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleTest {
  private WebDriver webDriver;

   private  String email;
   private  String pass;



    @Factory(dataProviderClass = MyDataProvider.class, dataProvider = "param")
    public GoogleTest( String email, String pass) {
this.email=email;
this.pass=pass;
    }


   @BeforeMethod
    public void setupDriver( ) {
       webDriver = WebDriverFactory.getInstance();
   }




    @Test
    public void gmailTest() {

        GmailBO gmailBO = new GmailBO(webDriver);
        gmailBO.login( webDriver, email, pass );
        gmailBO.selectEmails(  );
        GmailMainPage gmailMainPage = new GmailMainPage( webDriver );
        String expectedId = gmailMainPage.firstEmailId();
        gmailBO.deleteEmails(  );
        gmailBO.undoDeleting(  );
        Assert.assertEquals(gmailMainPage .expectedResult( expectedId ), 1 );
    }

    @AfterMethod
    public final void tearDown() {
        webDriver.quit();
    }
}
