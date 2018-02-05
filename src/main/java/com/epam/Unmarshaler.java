package com.epam;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Unmarshaler {

    private static final String FILE_NAME = "src/main/resources/testdata.xml";

    public static TestData getTestData () {
        try {
            JAXBContext context = JAXBContext.newInstance(TestData.class);
            Unmarshaller un = context.createUnmarshaller();
            return (TestData) un.unmarshal(new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
