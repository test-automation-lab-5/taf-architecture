package com.epam.lab.facadetask.decorator.bo.pages;


import com.epam.lab.facadetask.decorator.handler.CustomPageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class GmailPage extends AbstractPage{
    private Logger log = Logger.getLogger(GmailPage.class);
    @FindBy(xpath="//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement composeButton;
    @FindBy(xpath="//textarea[@name='to']")
    private WebElement receiver;
    @FindBy(xpath="//input[@name='subjectbox']")
    private WebElement subject;
    @FindBy(xpath="//div[@aria-multiline='true']")
    private WebElement message;
    @FindBy(css="div[data-tooltip*='Enter']")
    private WebElement enterButton;
    @FindBy(xpath="//a[@href='https://mail.google.com/mail/u/0/#sent']")
    private WebElement sentFolder;
    @FindBy(xpath="//div[@role='main']//div[@role='checkbox']")
    private WebElement checkbox;
    @FindBy(xpath="//div[@gh='mtb']//div[@act='10']")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[@role='alertdialog']//button[@name='ok']")
    private WebElement confirmDeleteButton;
    @FindBy(xpath = "//span[@class='bofITb']")
    private WebElement movedToTrashMessage;

    public GmailPage(){

        super(new CustomPageFactory());
    }

    public void sendMessage(String to, String sub, String mess){
        log.info("Composing Letter");
        waitToBeClickable(composeButton).click();
        receiver.sendKeys(to);
        subject.sendKeys(sub);
        message.sendKeys(mess);
        enterButton.click();
        log.info("Letter was sent");
        waitToBeClickable(sentFolder);
    }

    public void goToSentFolder(){
        sentFolder.click();
        waitToBeClickable(checkbox);
        }

    public void removeLetter(){
        waitToBeClickable(checkbox);
        log.info("Opened sent folder");
        checkbox.click();
        log.info("Clicked on the checkbox");
        deleteButton.click();
        confirmDeleteButton.click();
        log.info("Confirmed removal");
    }

    public String getComposeCheck(){
        return composeButton.getText();
    }
    public String getMovedToTrashMessage(){
        return movedToTrashMessage.getText();
    }
}
