package task3.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task3.waiter.Waiter;
import task3.pageElements.Button;

import java.util.logging.Logger;

public class SentMessagePage extends AbstractPage {
    private static final Logger log = Logger.getLogger(String.valueOf(SentMessagePage.class));
    @FindBy(xpath= "//a[@href='https://mail.google.com/mail/u/0/#sent']")
    private Button sentMessages;
    @FindBy(xpath= "//div[@role='main']//div[@role='checkbox']")
    private Button markCheckBox;
    @FindBy(xpath= "//div[@gh='tm']//div[@act='10']")
    private Button ClickDeleteIcon;
    @FindBy(name= "ok")
    private Button okmessage;

    public void clicklinkSentMessage(){
        sentMessages.click();
    }
    public void getcheckboxVisible() {
        Waiter.waitFor(driver,ExpectedConditions.elementToBeClickable(markCheckBox));
        markCheckBox.click();
        log.info("You marked checkbox");
    }
    public void clickDelete(){
        ClickDeleteIcon.click();
        okmessage.click();
        log.info("Messages is deleted");
    }
    public boolean isMessagePresent(String receiver){
        return driver.findElements(By.xpath("//*[@email='" + String.format("%s", receiver) + "']")).size() > 0;
    }

}