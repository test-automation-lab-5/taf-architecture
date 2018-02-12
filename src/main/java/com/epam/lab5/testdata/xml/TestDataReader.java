package com.epam.lab5.testdata.xml;

import com.epam.lab5.testdata.xml.entities.MailComponent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.epam.lab5.consts.Paths.TEST_DATA_XML_FILE_PATH;

public class TestDataReader {

    public String getSubjectFieldValue(){
        return getMailComponent().getSubjectField();
    }

    public String getMessageFieldValue(){
        return getMailComponent().getMessageField();
    }

    private MailComponent getMailComponent()  {
        MailComponent mailComponent = null;
        try {
            mailComponent = xmlJaxbReader(TEST_DATA_XML_FILE_PATH);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return mailComponent;
    }

    private MailComponent xmlJaxbReader(String pathName) throws JAXBException {
        File file = new File(pathName);
        JAXBContext jaxbContext = JAXBContext.newInstance(MailComponent.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (MailComponent) unmarshaller.unmarshal(file);
    }
}
