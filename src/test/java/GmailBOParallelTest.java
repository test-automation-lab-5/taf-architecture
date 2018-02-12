import com.epam.datasource.Unmarshaler;
import com.epam.businessobject.LoginBO;
import com.epam.businessobject.SendEmailBO;
import com.epam.driver.DriverManager;
import com.epam.datasource.LetterData;
import com.epam.datasource.User;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.util.List;

import static com.epam.datasource.Constants.*;

public class GmailBOParallelTest {

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getThread();
    }

    private List<User> users;
    private List<LetterData> letters;


    @DataProvider(parallel = true)
    public Object[][] getData() {
        try {
            users = Unmarshaler.unMarshalUsersData();
            letters = Unmarshaler.unMarshalLettersData();
        }catch (JAXBException ex){
            ex.printStackTrace();
        }
        return new Object[][]{
                {users.get(0), letters.get(0)},
                {users.get(1), letters.get(0)},
                {users.get(2), letters.get(0)},
                {users.get(3), letters.get(0)},
                {users.get(4), letters.get(0)}
        };

    }


    @Test(dataProvider = "getData")
    public void testGMail(User user, LetterData letterData) {

        LoginBO loginBO = new LoginBO();
        loginBO.logIn(user.getLogin(), user.getPassword());
        Assert.assertTrue(loginBO.getActualGmailTitle().contains(HOME_TITLE));

        SendEmailBO sendEmailBO = new SendEmailBO();
        sendEmailBO.sendMessage(letterData.getSentToWrong(), letterData.getSubject(), letterData.getMessage());
        String actualError = sendEmailBO.processError();
        Assert.assertTrue(actualError.contains(EXPECTED_ERROR));

        sendEmailBO.closeMailWindow();
        sendEmailBO.sendMessage(letterData.getSentTo(), letterData.getSubject(), letterData.getMessage());
        Boolean wasSent = sendEmailBO.verifySendingEmail();
        Assert.assertTrue(wasSent);

    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.releaseThread();
    }


}


