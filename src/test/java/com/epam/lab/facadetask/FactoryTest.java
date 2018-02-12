package com.epam.lab.facadetask;

import com.epam.lab.facadetask.decorator.bo.businessobjects.GmailMessage;
import com.epam.lab.facadetask.decorator.bo.businessobjects.Login;
import com.epam.lab.facadetask.driver.DriverObject;
import com.epam.lab.facadetask.testdata.model.TestMessage;
import com.epam.lab.facadetask.testdata.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTest {

    private User user;
    private TestMessage testMessage;

    @Factory(dataProviderClass = GmailTest.class, dataProvider = "getData")
    public FactoryTest(TestMessage testMessage, User user){
        this.testMessage = testMessage;
        this.user = user;

    }

    @Test
    public void testGmail() {
        String gmailURL = "https://accounts.google.com/signin";
        DriverObject.getDriver().get(gmailURL);
        Login loginPage = new Login();
        loginPage.login(user.getEmail(), user.getPassword());
        GmailMessage gmailPage = new GmailMessage();
        gmailPage.sendMessage(testMessage.getReceiver(), testMessage.getSubject(), testMessage.getMessage());
        gmailPage.removeMessage();
        Assert.assertTrue(gmailPage.isRemoved());
    }

    @AfterMethod
    public void quitDriver(){
        DriverObject.getDriver().quit();
    }




}
