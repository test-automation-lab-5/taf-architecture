package com.epam.lab.facadetask;

import com.epam.lab.facadetask.decorator.bo.businessobjects.GmailMessage;
import com.epam.lab.facadetask.decorator.bo.businessobjects.Login;
import com.epam.lab.facadetask.driver.DriverObject;

import com.epam.lab.facadetask.testdata.marshall.UnMarshell;
import com.epam.lab.facadetask.testdata.model.TestMessage;
import com.epam.lab.facadetask.testdata.model.TestMessages;
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
    private List<User> usersList;

    @BeforeMethod
    public void setUpDriver(){
        driver = DriverObject.getDriver();
    }

    @DataProvider(name = "users", parallel = true)
    public Object[][] getData() {
        File usersXml = new File("src\\\\main\\\\java\\\\com\\\\epam\\\\lab\\\\facadetask\\\\testdata\\\\users.xml");
        TestMessages messages =  UnMarshell.unmarshaller();
        assert messages != null;
        List<TestMessage> mess = messages.getTestMessages();
        try {
            usersList = JAXB.unmarshal(usersXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new Object[][]{
                {mess.get(0), usersList.get(0)},
                {mess.get(1), usersList.get(1)},
                {mess.get(2), usersList.get(2)},
                {mess.get(2), usersList.get(3)},
                {mess.get(2), usersList.get(4)},

        };
    }


    @Test(dataProvider = "users")
    public void testGmail(TestMessage message, User users) {
        String gmailURL = "https://accounts.google.com/signin";
        driver.get(gmailURL);
        Login loginPage = new Login();
        loginPage.login(users.getEmail(), users.getPassword());
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

