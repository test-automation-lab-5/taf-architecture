package main.pages;

import main.constants.Constants;
import main.pages.decorator.elements.Button;
import main.pages.decorator.elements.Input;
import main.pages.decorator.elements.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LetterWindowPage extends AbstractGmailPage {

    @FindBy(xpath = "//div[@role='button' and @class='T-I J-J5-Ji T-I-KE L3']")
    private Button composeButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private Input inputTo;

    @FindBy(xpath = "//span[@class='aB gQ pE']")
    private Link cc;

    @FindBy(xpath = "//textarea[@name='cc']")
    private Input inputCc;

    @FindBy(xpath = "//span[@class='aB  gQ pB']")
    private Link bcc;

    @FindBy(xpath = "//textarea[@name='bcc']")
    private Input inputBcc;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private Input subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private Input messageTextArea;

    @FindBy(xpath = "//img[@alt='Close']")
    private Button closeAndSave;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private Button sendButton;

    @FindBy(xpath = "//form[@method='POST']/input[@name='subject' and @type='hidden']")
    private Input hiddenSubjectInput;

    public LetterWindowPage(WebDriver driver) {
        super(driver);
    }

    public void enterTo(String to) {
        waitUntilAttributeBeVisible(inputTo);
        inputTo.sendKeys(to);
    }

    public void enterCc(String cc) {
        this.cc.click();
        inputCc.sendKeys(cc);
    }

    public void enterBcc(String bcc) {
        this.bcc.click();
        inputBcc.sendKeys(bcc);
    }

    public void closeAndSaveLetter() {
        closeAndSave.click();
    }

    public void enterSubject(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageTextArea.sendKeys(message);
    }

    public void sendLetter() {
        sendButton.click();
    }

    public String getSubjectFromInput() {
        if (hiddenSubjectInput.getWebElement().getAttribute(Constants.VALUE).length() == 0) {
            return null;
        } else {
            return subjectInput.getWebElement().getAttribute(Constants.VALUE);
        }
    }

    public void clickComposeButton() {
        composeButton.click();
    }
}
