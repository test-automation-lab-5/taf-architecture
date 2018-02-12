package com.epam.datasource;

import com.epam.unused.TestData;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static com.epam.datasource.Constants.*;

public class Unmarshaler {

    private static final String FILE_NAME = "src/main/resources/testdata.xml";


    /*public static void main(String[] args) {
        try {
            List<User> users = unmarshalUsersData();
            System.out.println(users.get(0).getLogin());
            List<LetterData> letters = unmarshallLettersData();
            System.out.println(letters.get(0).getSentTo());
        }catch (JAXBException ex){
            ex.printStackTrace();
        }
    }*/

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

    public static List<User> unMarshalUsersData () throws  JAXBException {
        UsersData usersData;
        JAXBContext context = JAXBContext.newInstance(UsersData.class);
        Unmarshaller um = context.createUnmarshaller();
        usersData = (UsersData) um.unmarshal(new File(FILE_USERS));
        return usersData.getUsersData();
    }

    public static List<LetterData> unMarshalLettersData () throws JAXBException {
        LettersData lettersData;
        JAXBContext context = JAXBContext.newInstance(LettersData.class);
        Unmarshaller um = context.createUnmarshaller();
        lettersData = (LettersData) um.unmarshal(new File(FILE_LETTERS));
        return lettersData.getLettersData();
    }
}


