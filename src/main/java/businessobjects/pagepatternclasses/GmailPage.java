package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.Button;
import businessobjects.pagepatternclasses.decorator.elements.elements.CheckBox;
import businessobjects.pagepatternclasses.decorator.elements.elements.TextInput;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import org.openqa.selenium.support.FindBy;
import testdata.LetterDataUnMarshaller;
import testdata.xmlmodels.LetterData;

public class GmailPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button composeButton;
    @FindBy(xpath = "//textarea[@class='vO']")
    private TextInput sendToInput;
    @FindBy(xpath = "//input[@class='aoT']")
    private TextInput subjectInput;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private TextInput messageInput;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private Button sendButton;
    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/#sent']")
    private Button sentPage;
    @FindBy(xpath = "//td[@class='oZ-x3 xY']")
    private CheckBox choosenMail;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private Button deleteButton;
    @FindBy(xpath = "//div[@role='alertdialog']//button[@name='ok']")
    private Button deleteOkButton;
    @FindBy(xpath = "//span[@class='bofITb']")
    private TextInput movedMessage;

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

    public String getMovedMessage() {
        String message = movedMessage.getText();
        return message;
    }

    public String getSubject() {
        LetterData letterData = LetterDataUnMarshaller.unmarsaller();
        String subject = letterData.getSubject();
        String letterSubject = getSubject(subject);
        return letterSubject;
    }

}
