package main.pages;

import main.pages.decorator.elements.Button;
import main.pages.decorator.elements.Input;
import main.pages.decorator.elements.Link;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LetterWindowPage extends AbstractGmailPage {

    private static final Logger log = Logger.getLogger(LetterWindowPage.class);

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
        log.info("Enter data in \"to\" input");
        waitUntilAttributeBeVisible(inputTo);
        inputTo.sendKeys(to);
    }

    public void enterCc(String cc) {
        log.info("Click on \"cc\"");
        this.cc.click();

        log.info("Enter data in \"cc\" input");
        inputCc.sendKeys(cc);
    }

    public void enterBcc(String bcc) {
        log.info("Click on \"bcc\"");
        this.bcc.click();

        log.info("Enter data in \"bcc\" input");
        inputBcc.sendKeys(bcc);
    }

    public void closeAndSaveLetter() {
        log.info("Click save and close");
        closeAndSave.click();
    }

    public void enterSubject(String subject) {
        log.info("Enter data in \"subject\" input");
        subjectInput.sendKeys(subject);
    }

    public void enterMessage(String message) {
        log.info("Enter data in \"message\" input");
        messageTextArea.sendKeys(message);
    }

    public void sendLetter() {
        log.info("Click send");
        sendButton.click();
    }

    public String getSubjectFromInput() {
        if (hiddenSubjectInput.getWebElement().getAttribute("value").length() == 0) {
            return null;
        } else {
            return subjectInput.getWebElement().getAttribute("value");
        }
    }

    public void clickComposeButton() {
        log.info("Click \"compose\" button");
        composeButton.click();
    }
}
