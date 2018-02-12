package task3.xml;
import task3.constants.Constants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.stream.IntStream;

public class DataXML {
    public static Object[][] parse() {
        try {
            File file = new File(Constants.FILE_PATH_USERSDATA);
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users) jaxbUnmarshaller.unmarshal(file);

            File fileData = new File(Constants.FILE_PATH_DATA);
            JAXBContext jaxbContext2 = JAXBContext.newInstance(Messages.class);
            Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
            Messages messages = (Messages) jaxbUnmarshaller2.unmarshal(fileData);

            List<User> usersList = users.getUser();
            List<Message> messagesList = messages.getMessage();

            return IntStream
                    .range(0, Constants.THREAD)
                    .mapToObj((int i) -> new Object[]{Objects.requireNonNull(messagesList).get(i), Objects.requireNonNull(usersList).get(i)})
                    .toArray(Object[][]::new);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}

