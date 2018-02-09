package com.epam.lab;

import com.epam.lab.businessObjects.MailBusinessObject;
import com.epam.lab.businessObjects.LoginBusinessObject;
import com.epam.lab.xmlModel.MessageDataProp;
import com.epam.lab.xmlModel.XmlToData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    private static WebDriver driver = null;
    private static WebDriverWait wait = null;

    private List<MessageDataProp> dataList;
    private String myEmail;
    private String myPassword;


    @Factory(dataProviderClass = ParallelTestData.class, dataProvider = "testData")
    public LoginTest(String myEmail, String myPassword) {
        this.myEmail = myEmail;
        this.myPassword = myPassword;
    }


    @BeforeMethod
    public static void open() {

        GlobalConfiguration.loadProperties();
        System.setProperty(com.epam.lab.GlobalConfiguration.NAME_DRIVER, com.epam.lab.GlobalConfiguration.PATH_DRIVER);
        driver = DriverThreadInit.getInstance().getDriver();
        driver.navigate().to(GlobalConfiguration.URL);

    }


    @Test
    public void composeMail() {
        dataList = XmlToData.getMessageData();
        LoginBusinessObject loginBusinessObject = new LoginBusinessObject(driver);
        MailBusinessObject mailBusinessObject = new MailBusinessObject(driver);
        loginBusinessObject.loginUser(myEmail, myPassword);
        mailBusinessObject.composeWrongMail(dataList.get(0).getIncorrectMail(), dataList.get(0).getTestSubject(), dataList.get(0).getTestMessage());
        assertTrue(mailBusinessObject.verifyAlertMessage());
        mailBusinessObject.clickAlertMessage();
        mailBusinessObject.composeRightMail(dataList.get(0).getCorrectMail());
        assertEquals(dataList.get(0).getCorrectMail(), mailBusinessObject.checkMail());
    }

    @AfterMethod
    public static void close() {
        DriverThreadInit.getInstance().removeDriver();
    }
}
