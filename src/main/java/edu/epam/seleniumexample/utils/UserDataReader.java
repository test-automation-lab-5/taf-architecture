package edu.epam.seleniumexample.utils;

import edu.epam.seleniumexample.utils.testdata.User;
import edu.epam.seleniumexample.utils.testdata.UserList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class UserDataReader {
    public static List<User> unmarshalXML(String filePath) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(UserList.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        UserList users = (UserList) unmarshaller.unmarshal(new File(filePath));
        // after parse processing
        for (User user : users.getUsers()) {
            user.setLogin(user.getLogin().trim());
            user.setPassword(user.getPassword().trim());
        }
        return users.getUsers();
    }
}
