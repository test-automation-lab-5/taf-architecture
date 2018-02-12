package task3;
import org.testng.annotations.*;
import task3.assertions.Assertion;
import task3.businessObjects.MessagesBO;
import task3.businessObjects.LoginBO;
import task3.constants.Constants;
import task3.driver.DriverManager;
import task3.xml.Message;
import task3.xml.DataXML;
import task3.xml.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RunTest3 {
    private static DataXML dataXML;
        @DataProvider(parallel = true)
        public Object[][] userData(){
            return DataXML.parse();
        }
        @Test(dataProvider = "userData")
        public void GmailTest(Message message, User user) throws InterruptedException{
            LoginBO loginBO = new LoginBO();
            Assertion assertion = new Assertion();
            loginBO.testlogin(user.getEmail(),user.getPassword());
            MessagesBO gmailMessage = new MessagesBO();
            gmailMessage.createNewMessage();
            gmailMessage.typeMessageDataAndSend(message.getReceiver(), message.getSubject(), message.getContent());
            assertion.verifyMessagePresenceByReceiver(message.getReceiver());
            gmailMessage.deleteMessage();
            assertion.verifyMessageAbsentsByReceiver(message.getReceiver());
        }
        @AfterMethod
        public static void quit(){
            DriverManager.getInstance().closeDriver();
        }
}
