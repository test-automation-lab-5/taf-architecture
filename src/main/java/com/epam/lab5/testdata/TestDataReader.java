package com.epam.lab5.testdata;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.epam.lab5.consts.Paths.TEST_DATA_XML_FILE_PATH;

public class TestDataReader {

    public static String getToFieldValue(){
        return getMailComponent().getToField();
    }

    public static  String getSubjectFieldValue(){
        return getMailComponent().getSubjectField();
    }

    public static String getMessageFieldValue(){
        return getMailComponent().getMessageField();
    }

    private static MailComponent getMailComponent()  {
        MailComponent mailComponent = null;
        try {
            mailComponent = xmlJaxbReader(TEST_DATA_XML_FILE_PATH);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return mailComponent;
    }

    private static<T> MailComponent xmlJaxbReader(String pathName) throws JAXBException {
        File file = new File(pathName);
        JAXBContext jaxbContext = JAXBContext.newInstance(MailComponent.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T unmarshalledObject = (T) unmarshaller.unmarshal(file);
        return (MailComponent)unmarshalledObject;
    }
}
