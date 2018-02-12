package task3.xml;
import task3.constants.Constants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class DataXML {
    public static List<User> unmarshalUser() {
        try {
            File file = new File(Constants.FILE_PATH_USERSDATA);
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users) jaxbUnmarshaller.unmarshal(file);
            return users.getUser();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Message> unmarshalMessage() {
        try {
            File fileData = new File(Constants.FILE_PATH_DATA);
            JAXBContext jaxbContext = JAXBContext.newInstance(Messages.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Messages messages = (Messages) jaxbUnmarshaller.unmarshal(fileData);
            return messages.getMessage();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}

