package epam.com.pomgmail.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class ParseXML {
    public static List<User> unmarshalXML() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Users.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Users users = (Users) unmarshaller.unmarshal(new File("usersdata.xml"));
        return users.getUsers();

//        Marshaller marshaller = jc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(users.getUsers(), System.out);
    }

}
