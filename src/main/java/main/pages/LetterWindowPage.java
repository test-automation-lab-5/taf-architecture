package main.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterWindowPage extends AbstractGmailPage {

    private static final Logger log = Logger.getLogger(LetterWindowPage.class);

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3' and @role='button']")
    private WebElement composeButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement inputTo;

    @FindBy(xpath = "//span[@class='aB gQ pE']")
    private WebElement cc;

    @FindBy(xpath = "//textarea[@name='cc']")
    private WebElement inputCc;

    @FindBy(xpath = "//span[@class='aB  gQ pB']")
    private WebElement bcc;

    @FindBy(xpath = "//textarea[@name='bcc']")
    private WebElement inputBcc;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement messageTextArea;

    @FindBy(xpath = "//img[@alt='Close']")
    private WebElement closeAndSave;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement sendButton;

    @FindBy(xpath = "//form[@method='POST']/input[@name='subject' and @type='hidden']")
    private WebElement hiddenSubjectInput;

    public LetterWindowPage(WebDriver driver) {
        super(driver);
    }

    public void enterTo(String to) {
        log.info("Enter data in \"to\" input");
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

    public void waitUntilBeClickable(int seconds) {
        waitUntilElementBeClickable(inputTo, seconds);
    }

    public void sendLetter() {
        log.info("Click send");
        sendButton.click();
    }

    public String getSubjectFromInput() {
        if (hiddenSubjectInput.getAttribute("value").length() == 0) {
            return null;
        } else {
            return subjectInput.getAttribute("value");
        }
    }

    public void clickComposeButton() {
        log.info("Click \"compose\" button");
        composeButton.click();
    }
}
