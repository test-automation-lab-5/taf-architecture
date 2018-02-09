package main.domparser;

import main.domparser.xmlmodels.MessageData;
import main.domparser.xmlmodels.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomXmlParsing {
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src\\main\\resources\\usersData.xml");
            NodeList usersNodeList = document.getElementsByTagName("user");

            for (int i = 0; i < usersNodeList.getLength(); i++) {
                Element singleUser = (Element) usersNodeList.item(i);
                User user = new User();

                user.setEmail(singleUser.getElementsByTagName("email").item(0).getChildNodes().item(0).getNodeValue());
                user.setPassword(singleUser.getElementsByTagName("password").item(0).getChildNodes().item(0).getNodeValue());

                users.add(user);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<MessageData> getDataForMessage() {
        List<MessageData> messageDatas = new ArrayList<>();

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src\\main\\resources\\letterData.xml");
            NodeList letters = document.getElementsByTagName("letter");

            for (int i = 0; i < letters.getLength(); i++) {
                Element singleLetter = (Element) letters.item(i);
                MessageData messageData = new MessageData();

                messageData.setTo(singleLetter.getElementsByTagName("to").item(0).getChildNodes().item(0).getNodeValue());
                messageData.setCc(singleLetter.getElementsByTagName("cc").item(0).getChildNodes().item(0).getNodeValue());
                messageData.setBcc(singleLetter.getElementsByTagName("bcc").item(0).getChildNodes().item(0).getNodeValue());
                messageData.setSubject(singleLetter.getElementsByTagName("subject").item(0).getChildNodes().item(0).getNodeValue());
                messageData.setMessage(singleLetter.getElementsByTagName("message").item(0).getChildNodes().item(0).getNodeValue());

                messageDatas.add(messageData);
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return messageDatas;
    }
}
