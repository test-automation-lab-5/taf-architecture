package com.epam.lab.facadetask;

import com.epam.lab.facadetask.driver.DriverObject;
import com.epam.lab.facadetask.model.TestMessage;
import com.epam.lab.facadetask.model.User;
import com.epam.lab.facadetask.testdata.marshall.JAXB;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GmailTest {
    private static WebDriver driver;
    private TestMessage message;
    private List<User> usersList;

    @BeforeClass
    public void launch() throws IOException {

        driver = DriverObject.getDriver();
        File usersXml = new File("src\\\\main\\\\java\\\\com\\\\epam\\\\lab\\\\pagefactory\\\\testdata\\\\users.xml");
        try{
            usersList = JAXB.unmarshal(usersXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGmail() {

               }

    @AfterClass
    public static void quitBrowser(){
        try{
            driver.close();
        }finally{
        driver.quit();
        }
    }
}

