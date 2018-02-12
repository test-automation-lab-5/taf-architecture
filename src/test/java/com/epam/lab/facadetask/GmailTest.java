package com.epam.lab.facadetask;

import com.epam.lab.facadetask.testdata.marshall.UnMarshell;
import com.epam.lab.facadetask.testdata.model.TestMessage;
import com.epam.lab.facadetask.testdata.model.TestMessages;
import com.epam.lab.facadetask.testdata.model.User;
import com.epam.lab.facadetask.testdata.marshall.JAXB;

import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class GmailTest {
    private static List<User> usersList;

    @DataProvider(parallel = true)
    public static Object[][] getData() {
        File usersXml = new File("src\\\\main\\\\java\\\\com\\\\epam\\\\lab\\\\facadetask\\\\testdata\\\\users.xml");
        TestMessages mess =  UnMarshell.unmarshaller();
        assert mess != null;
        List<TestMessage> messages = mess.getTestMessages();
        try {
            usersList = JAXB.unmarshal(usersXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new Object[][]{
                {messages.get(0), usersList.get(0)},
                {messages.get(1), usersList.get(1)},
                {messages.get(2), usersList.get(2)},
                {messages.get(3), usersList.get(3)},
                {messages.get(4), usersList.get(4)},
        };
    }
}