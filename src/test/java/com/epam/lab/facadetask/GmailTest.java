package com.epam.lab.facadetask;

import com.epam.lab.facadetask.decorator.bo.businessobjects.GmailMessage;
import com.epam.lab.facadetask.decorator.bo.businessobjects.Login;
import com.epam.lab.facadetask.driver.DriverObject;
import com.epam.lab.facadetask.propertyreader.ReadPropertyFile;
import com.epam.lab.facadetask.testdata.marshall.UnMarshell;
import com.epam.lab.facadetask.testdata.model.TestMessage;
import com.epam.lab.facadetask.testdata.model.User;
import com.epam.lab.facadetask.testdata.marshall.JAXB;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class GmailTest {
    private static WebDriver driver;
    private TestMessage message;
    private List<User> usersList;
    private String GmailURL = null;

    @BeforeMethod
    public void launch() {

        driver = DriverObject.getDriver();
        File usersXml = new File("src\\\\main\\\\java\\\\com\\\\epam\\\\lab\\\\facadetask\\\\testdata\\\\users.xml");
        message = UnMarshell.unmarshaller();
        try{
            usersList = JAXB.unmarshal(usersXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGmail() {
        if (!usersList.isEmpty()) {
            GmailURL = usersList.get(0).getSignin();
        }
        driver.get(GmailURL);
        Login loginPage = new Login();
        loginPage.login(usersList.get(0));
        GmailMessage gmailPage = new GmailMessage();
        gmailPage.sendMessage(message.getReceiver(), message.getSubject(), message.getMessage());
        gmailPage.removeMessage();
        Assert.assertTrue(gmailPage.isRemoved());


    }
    @AfterMethod
    public static void quitBrowser(){
        try{
            driver.close();
        }finally{
        driver.quit();
        }
    }
}

