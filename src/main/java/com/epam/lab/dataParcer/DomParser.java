package com.epam.lab.dataParcer;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private List<Account> accountList = new ArrayList<>();


    public DomParser() {
    }

    public List<Account> parse(File inputFile) {


        try

        {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse( inputFile );
            doc.getDocumentElement().normalize();
            System.out.println( "Root element :" + doc.getDocumentElement().getNodeName() );
            NodeList nList = doc.getElementsByTagName( "account" );
            System.out.println( "----------------------------" );

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item( temp );
                System.out.println( "\nCurrent Element :" + nNode.getNodeName() );

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Account account = new Account();
                    account.setLogin( eElement.getElementsByTagName( "login" ).item( 0 ).getTextContent() );
                    account.setPassword( eElement.getElementsByTagName( "password" ).item( 0 ).getTextContent() );
                    accountList.add( account );

                }
            }
        } catch (Exception e)

        {
            e.printStackTrace();

        }
        return accountList;
    }
}


