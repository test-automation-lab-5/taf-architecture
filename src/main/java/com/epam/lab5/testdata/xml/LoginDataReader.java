package com.epam.lab5.testdata.xml;

import com.epam.lab5.testdata.xml.entities.User;
import com.epam.lab5.testdata.xml.entities.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static com.epam.lab5.consts.Paths.LOGIN_XML_FILE_PATH;

public class LoginDataReader {

    public static List<User> getUserList()  {
        Users users = null;
        try {
            users = xmlJaxbReader(LOGIN_XML_FILE_PATH);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return users.getUserList();
    }

    private static Users xmlJaxbReader(String pathName) throws JAXBException {
        File file = new File(pathName);
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Users) unmarshaller.unmarshal(file);
    }
}
