package com.epam.lab.businessObjects;

import com.epam.lab.decorator.MyButton;
import com.epam.lab.decorator.MyDecorator;
import com.epam.lab.decorator.MyTextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class MailPage {

    @FindBy(xpath = "//*[@class='z0']")
    private MyButton composeButton;

    @FindBy(name = "to")
    private MyTextInput senderMailField;

    @FindBy(name = "subjectbox")
    private MyTextInput subjectMailField;

    @FindBy(xpath = "//*[@role=\"textbox\"]")
    private MyTextInput messageMailField;

    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private MyButton submitButton;

    @FindBy(xpath = "//button[text()='OK']")
    private MyButton alertOkButton;

    @FindBy(xpath = "//div[@class='aoD hl']")
    private MyTextInput composeMailField;


    @FindBy(css = ".vM")
    private MyButton closeSenderMailButton;

    @FindBy(css = ".ag")
    private MyButton sentMailFolderButton;

    /* @FindBy(xpath="//div[@class='BltHke nH oy8Mbf'][@role='main']")
     private WebElement openSentMailButton;
 */

    @FindBy(css = ".g2")
    private MyButton lastMessageButton;

    public MailPage(WebDriver driver) {

        PageFactory.initElements(new MyDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    public void typeMessage(String incorrectMessage, String subject, String message) {
        composeButton.click();
        senderMailField.sendKeys(incorrectMessage);
        subjectMailField.sendKeys(subject);
        messageMailField.sendKeys(message);
    }

    public boolean verifyAlertMessage() {
        return alertOkButton.exists();
    }

    public void clickAlertMessage() {
        alertOkButton.click();
    }

    public void typeCorrectMessage(String correctMessage) {
        composeMailField.click();
        closeSenderMailButton.click();
        senderMailField.sendKeys(correctMessage);
    }


    public void submitMessage() {
        submitButton.click();
    }

    public String checkSentMail() {
        sentMailFolderButton.click();
        // openSentMailButton.click();
        lastMessageButton.click();
        return lastMessageButton.getAttribute("email");
    }
}
