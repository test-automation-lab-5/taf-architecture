package com.epam.task4;

import com.epam.task4.businessobjects.AuthorizationBO;
import com.epam.task4.businessobjects.MailboxBO;
import com.epam.task4.consts.Consts;
import com.epam.task4.drivers.SingletonDriver;
import com.epam.task4.preferences.Preferences;
import com.epam.task4.preferences.PreferencesLoadException;
import com.epam.task4.testdata.DataLoader;
import com.epam.task4.testdata.DataProviderTransformer;
import com.epam.task4.testdata.TestData;
import com.epam.task4.testdata.TestDataList;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class TestGmail {
    private static final Logger log = Logger.getLogger(TestGmail.class);

    @DataProvider(name = "userData", parallel = true)
    public static Object[][] getBrowserDataProvider(Method testMethod) throws JAXBException {
        return DataProviderTransformer.transformListToObjects(DataLoader.loadXMLFromResources(Consts.CONST_INPUT_DATA, TestDataList.class).getTestDataList());
    }

    @BeforeTest
    public void preferencesLoad() throws IOException, PreferencesLoadException {
        Preferences.initPreferences(Consts.CONST_PROPERTY_FILE_NAME);
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        SingletonDriver.acquireThread();
    }

    //@Test(dataProvider = "userData", threadPoolSize = 1, invocationCount = 2)
    @Test(dataProvider = "userData")
    public void testGmailDeleteMessage(TestData userData) {
        log.info("testGmailDeleteMessage start");
        new AuthorizationBO()
                .authorizeAs(
                        userData.getUserMail(),
                        userData.getUserPassword());
        MailboxBO mailBoxBO = new MailboxBO();
        List<String> idsOfDeletedElements = mailBoxBO
                .deleteFirstNMailsFromCurrentPool(userData.getElementsCount());
        Assert.assertTrue(mailBoxBO
                .undoAction()
                .verifyMessageRestoration(idsOfDeletedElements));
        log.info("testGmailDeleteMessage done");
    }

    @AfterMethod
    public void afterMethod() {
        SingletonDriver.releaseThread();
        /*if (!Objects.isNull(SingletonDriver.getDriver()))
            SingletonDriver.getDriver().quit();*/
    }
}