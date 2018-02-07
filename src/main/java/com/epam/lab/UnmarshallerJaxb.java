package com.epam.lab;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnmarshallerJaxb {
    public static void main(String args[]) throws JAXBException {

        System.out.println("Transform XML to Java code");
        JAXBContext entity = JAXBContext.newInstance(MyProperties.class);
        Unmarshaller unmashall = entity.createUnmarshaller();
        String fileName = "data/NewJAXB.xml";
        System.out.println("Reading from XML file 'NewJAXB.xml'");
        File xmlFile = new File(fileName);
        MyProperties newProperties = (MyProperties) unmashall.unmarshal(xmlFile);


        System.out.println(newProperties.getMyProperty().mail);
        System.out.println(newProperties.getMyProperty().password);


    }
}

