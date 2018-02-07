package com.epam.lab.facadetask.testdata.marshall;

import com.epam.lab.facadetask.testdata.model.TestMessages;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UnMarshell {
    public static TestMessages unmarshaller() {
        try {
            File file = new File("src\\\\main\\\\java\\\\com\\\\epam\\\\lab\\\\facadetask\\\\testdata\\\\testdata.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TestMessages.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (TestMessages) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}