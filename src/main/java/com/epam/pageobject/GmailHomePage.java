package com.epam.pageobject;

import com.epam.decorator.Button;
import com.epam.decorator.TextInput;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage  extends AbstractPage {


    @FindBy(xpath = "//div[@class='z0']/div")
    private Button composeButton;


    @FindBy(xpath = "//a[@href=\"https://mail.google.com/mail/u/0/#sent\"]")
    private Button sentEmailsButton;


    @FindBy(xpath = "//div[@class='y6']//b[text()='Email subject']")
    private Button sentEmailSubject;


    @FindBy(xpath = "//td//img[2]")
    private Button expandWindow;


    @FindBy(className = "vO")
    private TextInput gmailToAddress;


    @FindBy(className = "aoT")
    private TextInput gmailSubject;


    @FindBy(css = "div[class='Am Al editable LW-avf']")
    private TextInput gmailBody;


    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private Button sendButton;


    @FindBy(xpath = "//div[@class='oh J-Z-I J-J5-Ji T-I-ax7']/div")
    private Button trashButton;

    public void  clickTrashButton (){

        waitUntilBeClickable(trashButton);
        trashButton.clickOn();

    }

    public void pressComposeButton (){

        waitUntilBeClickable( composeButton);
        composeButton.clickOn();

    }

    public void goToSentEmails (){

        waitUntilBeClickable(sentEmailsButton);
                sentEmailsButton.clickOn();

    }

    public boolean checkIfWasSent (){

        return sentEmailSubject != null;
    }


    public void pressExpandWindow (){

        waitUntilBeClickable(expandWindow);
        expandWindow.clickOn();

    }

    public void setToAddress(String addressInput){

        waitUntilVisible(gmailToAddress);
        gmailToAddress.enterText(addressInput);

    }

    public void setGmailSubject (String subjectInput){

        waitUntilVisible(gmailSubject);
        gmailSubject.enterText(subjectInput);

    }

    public void setGmailBody (String bodyInput){

        waitUntilVisible(gmailBody);
        gmailBody.enterText(bodyInput);

    }

    public void pressSendButton (){

        waitUntilBeClickable(sendButton);
        sendButton.clickOn();

    }

}
