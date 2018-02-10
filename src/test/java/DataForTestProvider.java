import main.domparser.DomXmlParsing;
import main.domparser.xmlmodels.MessageData;
import main.domparser.xmlmodels.User;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.stream.IntStream;

public class DataForTestProvider {

    @DataProvider(parallel = true)
    public static Object[][] getData() {
        DomXmlParsing parse = new DomXmlParsing();
        List<User> usersData = parse.getUsers();
        List<MessageData> dataForMessageCompose = parse.getDataForMessage();

        return IntStream
                .range(0, 5)
                .mapToObj(i -> new Object[]{usersData.get(i), dataForMessageCompose.get(i)})
                .toArray(Object[][]::new);
    }
}
