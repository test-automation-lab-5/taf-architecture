package testdata;

import testdata.xmlmodels.User;
import testdata.xmlmodels.UsersData;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JAXBHendler {
    public static void marshal(List<User> users, File selectedFile) throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(UsersData.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new UsersData(users), writer);
        writer.close();
    }

    public static List<User> unmarshal(File importFile) throws JAXBException {
        UsersData usersData;
        JAXBContext context = JAXBContext.newInstance(UsersData.class);
        Unmarshaller um = context.createUnmarshaller();
        usersData = (UsersData) um.unmarshal(importFile);
        return usersData.getUserDataSet();
    }

}
