import org.testng.annotations.DataProvider;
import testdata.JAXBHendler;
import testdata.LetterDataUnMarshaller;
import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.User;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class GmailTest {
    private List<LetterData> lettersData;
    private List<User> usersData;

    @DataProvider(parallel = true)
    public Object[][] getData() {
        File lettersDataXml = new File("src\\\\main\\\\resources\\\\letterData.xml");
        File usersDataXml = new File("src\\\\main\\\\resources\\\\usersData.xml");
        try {
            lettersData = LetterDataUnMarshaller.unmarsallerLetterDatas(lettersDataXml);
            usersData = JAXBHendler.unmarshal(usersDataXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new Object[][]{
                {lettersData.get(0), usersData.get(0)},
                {lettersData.get(1), usersData.get(1)},
                {lettersData.get(2), usersData.get(2)},
                {lettersData.get(3), usersData.get(3)},
                {lettersData.get(4), usersData.get(4)}
        };

    }

}
