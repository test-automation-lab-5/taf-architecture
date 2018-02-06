package com.epam.task4;

import com.epam.task4.businessobjects.AuthorizationBO;
import com.epam.task4.businessobjects.MailBoxBO;
import com.epam.task4.consts.Consts;
import com.epam.task4.drivers.SingletonDriver;
import com.epam.task4.preferences.Preferences;
import com.epam.task4.preferences.PreferencesLoadException;
import com.epam.task4.testdata.DataLoader;
import com.epam.task4.testdata.UsersData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

public class TestGmail {
    private static final Logger log = Logger.getLogger(TestGmail.class);

    @DataProvider(name = "userData", parallel = true)
    public static Object[][] getBrowserDataProvider(Method testMethod) throws JAXBException {
        return DataLoader.LoadXMLFromResources("users.xml", UsersData.class).toObjects();
    }

    @BeforeTest
    public void preferencesLoad() throws IOException, PreferencesLoadException {
        log.info("Init preferences");
        Preferences.loadPreferences(Consts.CONT_PROPERTY_FILE_NAME);
        log.info("Preferences init complete");
    }

    @BeforeMethod
    public void before() {
        log.info("Init driver");
        SingletonDriver.getDriver();
        log.info("Driver init complete");
    }

    @Test(dataProvider = "userData")
    public void loginCheckDeleteUndo(String mail, String password) {
        log.info("LoginCheckDeleteUndo start");
        new AuthorizationBO()
                .authorizeAs(
                        mail,
                        password);
        MailBoxBO mailsManipulationBO = new MailBoxBO();
        List<String> idsOfDeletedElements = mailsManipulationBO
                .deleteFirstNMailsFromCurrentPool(Preferences.preferencesTestGmail.getElementsCount());
        Assert.assertTrue(mailsManipulationBO.undoActionAndVerifyRestoration(idsOfDeletedElements));
        log.info("LoginCheckDeleteUndo done");
    }

    @AfterMethod
    public void afterMethod() {
        if (!Objects.isNull(SingletonDriver.getDriver())) {
            log.info("Close driver");
            SingletonDriver.getDriver().quit();
        }
    }
}