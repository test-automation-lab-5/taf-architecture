import com.epam.datasource.Unmarshaler;
import com.epam.datasource.LetterData;
import com.epam.datasource.User;
import org.testng.annotations.DataProvider;

import javax.xml.bind.JAXBException;
import java.util.List;

public class BaseTest {
    private List<User> users;
    private List<LetterData> letters;


    @DataProvider(parallel = true)
    public Object[][] getData() {
        try {
            users = Unmarshaler.unMarshalUsersData();
            letters = Unmarshaler.unMarshalLettersData();
        } catch (JAXBException ex){
            ex.printStackTrace();
        }
        return new Object[][]{
                {users.get(0), letters.get(0)},
                {users.get(1), letters.get(0)},
                {users.get(2), letters.get(0)},
                {users.get(3), letters.get(0)},
                {users.get(4), letters.get(0)},

        };

    }
}
