package com.epam.lab;


import com.epam.lab.dataParcer.Account;
import com.epam.lab.dataParcer.DomParser;

import java.io.File;
import java.util.List;

public class MyDataProvider {

    @org.testng.annotations.DataProvider( name = "param", parallel = true)
    public static Object[][] credentials() {
        DomParser domParser = new DomParser();
        List<Account>accountList = domParser.parse( new File("C:\\Users\\Admin\\IdeaProjects\\seleniumpractice\\accounts") );
        Account one = accountList.get( 0 );
        Account two = accountList.get( 1 );
        return new Object[][] {
                {one.getLogin(),one.getPassword()},
                {two.getLogin(),two.getPassword()},
                {one.getLogin(),one.getPassword()},
                {two.getLogin(),two.getPassword()},
                {one.getLogin(),one.getPassword()}


        };

    }
}
