package epam.com.pomgmail.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class RetrieveUsersData {
    private static final String USERS_XML_FILE_PATH = "usersdata.xml";
    private static final String COUNT_MESSAGE_XML_FILE_PATH = "countofmessage.xml";

    public static List<User> getXMLUsersComponent()  {
        List<User> userData = null;
        try {
            userData = unmarshalXMLUsers(USERS_XML_FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    public static Integer getXMLComponent()  {
        Integer count = null;
        try {
            count = unmarshalXMLCount(COUNT_MESSAGE_XML_FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    private static List<User> unmarshalXMLUsers(String filePath) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Users.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Users users = (Users) unmarshaller.unmarshal(new File(filePath));
        return users.getUsers();
    }

    private static Integer unmarshalXMLCount(String filePath) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(CountOfMessage.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        CountOfMessage count = (CountOfMessage) unmarshaller.unmarshal(new File(filePath));
        return count.getCount();
    }

}
