package testdata;

import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.User;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class DataObject {
    public static Object[][] getDataObject() {
        File lettersDataXml = new File("src\\\\main\\\\resources\\\\letterData.xml");
        File usersDataXml = new File("src\\\\main\\\\resources\\\\usersData.xml");
        List<LetterData> letterDatas = LetterDataUnMarshaller.unmarsallerLetterDatas(lettersDataXml);
        List<User> users = null;
        try {
            users = JAXBHendler.unmarshal(usersDataXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Object[][] result = new Object[letterDatas.size()][2];
        for (int i = 0; i< letterDatas.size(); i++){
            result[i][0] = letterDatas.get(i);
            result[i][1] = users.get(i);
        }

        return result;
    }
}
