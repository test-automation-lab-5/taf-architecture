package com.epam.task2;

import com.epam.task2.businessobjects.AuthorizationBO;
import com.epam.task2.businessobjects.MailsManipulationBO;
import com.epam.task2.businessobjects.pageobjects.TestPage;
import com.epam.task2.consts.Consts;
import com.epam.task2.drivers.SingletonDriver;
import com.epam.task2.preferences.Preferences;
import com.epam.task2.preferences.PreferencesLoadException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TestGmail {
    private static final Logger log = Logger.getLogger(TestGmail.class);

    @BeforeClass
    public void before() throws IOException, PreferencesLoadException {
        log.info("Init preferences");
        Preferences.loadPreferences(Consts.CONT_PROPERTY_FILE_NAME);
        log.info("Preferences init complete");
        log.info("Init driver");
        SingletonDriver.getDriver();
        log.info("Driver init complete");
    }

    @Test
    public void loginCheckDeleteUndo() {
        log.info("LoginCheckDeleteUndo start");
        new AuthorizationBO()
                .authorizeAs(
                        Preferences.preferencesTestGmail.getUserMail(),
                        Preferences.preferencesTestGmail.getUserPassword());
        MailsManipulationBO mailsManipulationBO = new MailsManipulationBO();
        List<String> idsOfDeletedElements = mailsManipulationBO.deleteFirstNMailsFromCurrentPool(Preferences.preferencesTestGmail.getElementsCount());
        Assert.assertTrue(mailsManipulationBO.undoActionAndVerifyRestoration(idsOfDeletedElements));
        log.info("LoginCheckDeleteUndo done");
    }
    @Test
    public void testMyDecorator(){
        TestPage testPage = new TestPage();
        testPage
                .openPage()
                .typeMail("mixer.log4j@gmail.com");
        Assert.assertTrue(testPage.varifyTextTyped());
    }
    @AfterMethod
    public void afterMethod(){
        SingletonDriver.getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public void after() {
        if (!Objects.isNull(SingletonDriver.getDriver())) {
            log.info("Close driver");
            SingletonDriver.getDriver().close();
            SingletonDriver.getDriver().quit();
        }
    }
}