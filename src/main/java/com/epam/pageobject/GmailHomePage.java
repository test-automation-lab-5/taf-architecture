package com.epam.pageobject;

import com.epam.pageobject.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage  extends AbstractPage {


    WebDriverWait wait;

    public GmailHomePage (WebDriver driver){

        super(driver);
        wait = new WebDriverWait(driver,30);

    }



    @FindBy(xpath = "//div[@class='z0']/div")
    WebElement composeButton;


    //@FindBy(xpath = "//a[@title='Отправленные']")
    @FindBy(xpath = "//a[@href=\"https://mail.google.com/mail/u/0/#sent\"]")
    WebElement sentEmailsButton;


    @FindBy(xpath = "//div[@class='y6']//b[text()='Email subject']")
    WebElement sentEmailSubject;


    @FindBy(xpath = "//td//img[2]")
    WebElement expandWindow;


    @FindBy(className = "vO")
    WebElement gmailToAddress;


    @FindBy(className = "aoT")
    WebElement gmailSubject;


    @FindBy(css = "div[class='Am Al editable LW-avf']")
    WebElement gmailBody;


    //@FindBy(xpath = "//div[text()='Отправить']")
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    WebElement sendButton;


    @FindBy(xpath = "//div[@class='oh J-Z-I J-J5-Ji T-I-ax7']/div")
    WebElement trashButton;

    public void  clickTrashButton (WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", trashButton);
    }

    public void pressComposeButton (){

        wait.until(ExpectedConditions.elementToBeClickable(composeButton));
        composeButton.click();

    }

    public void goToSentEmails (){

        sentEmailsButton.click();

    }

    public void verifySendingEmail (){


        if (sentEmailSubject != null)
        {
            System.out.println("Email was sent successfully!");
        }
        else
        {
            System.out.println("Failed to send email");
        }
    }


    public void pressExpandWindow (){

        expandWindow.click();

    }

    public void setToAddress(String addressInput){

        gmailToAddress.sendKeys(addressInput);

    }

    public void setGmailSubject (String subjectInput){

        gmailSubject.sendKeys(subjectInput);

    }

    public void setGmailBody (String bodyInput){

        gmailBody.sendKeys(bodyInput);

    }

    public void pressSendButton (){

        sendButton.click();

    }

}
