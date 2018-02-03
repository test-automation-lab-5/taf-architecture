package pagepatternclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.LetterData;
import testdata.LetterDataUnMarshaller;

public class GmailPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement composeButton;
    @FindBy(xpath = "//textarea[@class='vO']")
    private WebElement sendToInput;
    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement subjectInput;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement messageInput;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private WebElement sendButton;
    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/#sent']")
    private WebElement sentPage;
    @FindBy(xpath = "//td[@class='oZ-x3 xY']")
    private WebElement choosenMail;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[@role='alertdialog']//button[@name='ok']")
    private WebElement deleteOkButton;
    @FindBy(xpath = "//span[@class='bofITb']")
    private WebElement movedMessage;

    public GmailPage(WebDriver driver) {
        super(driver);
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

    public void pushDeleteOkButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(deleteOkButton));
        deleteOkButton.click();
    }

    public String getMovedMessage() {
        String message = movedMessage.getText();
        return message;
    }

    public String getSubject(WebDriver driver) {
        LetterData letterData = LetterDataUnMarshaller.unmarsaller();
        String subject = letterData.getSubject();
        String letterSubject = driver.findElement(By.xpath("//*[@class='bog']//*[text()='" + String.format("%s", subject) + "']")).getText();
        return letterSubject;
    }


}
