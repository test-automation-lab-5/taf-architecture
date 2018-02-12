package task3.pages;
import org.openqa.selenium.support.FindBy;
import task3.pageElements.Button;
import task3.pageElements.PageElements;

import java.io.IOException;
import java.util.logging.Logger;
public class InboxMessagePage extends AbstractPage {
    private static final Logger log = Logger.getLogger(String.valueOf(InboxMessagePage.class));
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button message;



    public void clickmessage(){
        message.click();
        log.info("Welcome to inbox messages");
    }
}