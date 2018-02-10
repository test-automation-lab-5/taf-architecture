package main.domparser;

import main.constants.Constants;
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
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Constants.USER_XML_PATH);
            NodeList usersNodeList = document.getElementsByTagName(Constants.USER);

            for (int i = 0; i < usersNodeList.getLength(); i++) {
                Element singleUser = (Element) usersNodeList.item(i);

                users.add(new User.Builder()
                        .setEmail(singleUser.getElementsByTagName(Constants.EMAIL).item(0).getChildNodes().item(0).getNodeValue())
                        .setPassword(singleUser.getElementsByTagName(Constants.PASSWORD).item(0).getChildNodes().item(0).getNodeValue())
                        .build());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<MessageData> getDataForMessage() {
        List<MessageData> messageDatas = new ArrayList<>();

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Constants.MESSAGE_DATA_XML_PATH);
            NodeList letters = document.getElementsByTagName(Constants.LETTER);

            for (int i = 0; i < letters.getLength(); i++) {
                Element singleLetter = (Element) letters.item(i);
                messageDatas.add(new MessageData.Builder()
                        .setTo(singleLetter.getElementsByTagName(Constants.TO).item(0).getChildNodes().item(0).getNodeValue())
                        .setBcc(singleLetter.getElementsByTagName(Constants.BCC).item(0).getChildNodes().item(0).getNodeValue())
                        .setCc(singleLetter.getElementsByTagName(Constants.CC).item(0).getChildNodes().item(0).getNodeValue())
                        .setMessage(singleLetter.getElementsByTagName(Constants.MESSAGE).item(0).getChildNodes().item(0).getNodeValue())
                        .build());
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return messageDatas;
    }
}
