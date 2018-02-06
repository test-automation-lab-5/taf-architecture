package com.epam.task4.testdata;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DataLoader {
    private static final Logger log = Logger.getLogger(DataLoader.class);

    public static <E> E LoadXML(String fileURL, Class<E> datatype) throws JAXBException {
        File file = new File(fileURL);
        JAXBContext jc = JAXBContext.newInstance(datatype);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (E) unmarshaller.unmarshal(file);
    }

    public static <E> E LoadXMLFromResources(String fileName, Class<E> datatype) throws JAXBException {
        return LoadXML(DataLoader.class.getClassLoader().getResource(fileName).getPath().toString(), datatype);
    }
}
