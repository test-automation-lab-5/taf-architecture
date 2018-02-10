package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.ButtonImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.CheckBoxImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.TextInputImpl;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import drivers.DriverObject;
import org.openqa.selenium.support.FindBy;
import testdata.LetterDataUnMarshaller;
import testdata.xmlmodels.LetterData;

public class GmailPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private ButtonImpl composeButton;
    @FindBy(xpath = "//textarea[@class='vO']")
    private TextInputImpl sendToInput;
    @FindBy(xpath = "//input[@class='aoT']")
    private TextInputImpl subjectInput;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private TextInputImpl messageInput;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private ButtonImpl sendButton;
    @FindBy(xpath = "//a[@title='Sent Mail']")
    private ButtonImpl sentPage;
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private CheckBoxImpl choosenMail;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private ButtonImpl deleteButton;
    @FindBy(xpath = "//div[@role='alertdialog']//button[@name='ok']")
    private ButtonImpl deleteOkButton;
    @FindBy(xpath = "//span[@class='bofITb']")
    private TextInputImpl movedMessage;

    public GmailPage() {
        super(new MyPageFactory());
    }


    public void sendLetter(String to, String subject, String message) {
        composeButton.click();
        sendToInput.sendKeys(to);
        subjectInput.sendKeys(subject);
        messageInput.sendKeys(message);
        sendButton.click();
    }

    public void getSentPage() {
        sentPage.click();
    }

    public void removeLetterFromSend() {
        choosenMail.click();
        deleteButton.click();
    }

    public void pushDeleteOkButton() {
        waitUntilBeClickableAbstract(deleteOkButton);
        deleteOkButton.click();
    }

    public boolean getMovedMessage() {
        return movedMessage.isPresent();
    }

    public String getLetterSubject(String subject) {
        return getSubject(subject);
    }

}
