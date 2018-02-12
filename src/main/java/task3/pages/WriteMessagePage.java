package task3.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task3.pageElements.Button;
import task3.pageElements.Input;
import task3.pageElements.PageElements;


import java.io.IOException;
import java.util.logging.Logger;

public class WriteMessagePage extends AbstractPage {
    private static final Logger log = Logger.getLogger(String.valueOf(WriteMessagePage.class));
    @FindBy(xpath= "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button message;
    @FindBy(className= "vO")
    private Input receiver;
    @FindBy(xpath = "//input[@class='aoT']")
    private Input subject;
    @FindBy(xpath= "//div[@class='Am Al editable LW-avf']")
    private Input messageContent;
    @FindBy(xpath= "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private Button readyToSend;




    public void typeMessage(String reciver,String subjectMesage,String message){
        receiver.sendKeys(reciver);
        subject.sendKeys(subjectMesage);
        messageContent.sendKeys(message);
        readyToSend.click();
        log.info("Written message is sending now. " + message);

    }

}
