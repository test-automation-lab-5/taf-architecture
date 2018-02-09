import main.domparser.DomXmlParsing;
import main.domparser.xmlmodels.MessageData;
import main.domparser.xmlmodels.User;
import org.testng.annotations.DataProvider;

import java.util.List;

public class GmailTest {

    @DataProvider(name = "userData", parallel = true)
    public static Object[][] getData() {
        DomXmlParsing parse = new DomXmlParsing();
        List<User> users = parse.getUsers();
        List<MessageData> datas = parse.getDataForMessage();
        return new Object[][]{
                {users.get(0), datas.get(0)},
                {users.get(1), datas.get(1)},
                {users.get(2), datas.get(2)},
                {users.get(3), datas.get(3)},
                {users.get(4), datas.get(4)}
        };
    }
}
