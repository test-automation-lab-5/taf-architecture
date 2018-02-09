package com.epam.lab5.pageobjects;

import com.epam.lab5.decorator.elements.Button;
import com.epam.lab5.decorator.elements.PageElement;
import com.epam.lab5.decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposePage extends AbstractPage {

    private static final Logger log = Logger.getLogger(ComposePage.class);

    @FindBy(css = ".oj div textarea" )
    private TextInput mailToInput;

    @FindBy(name = "subjectbox")
    private TextInput mailSubjectInput;

    @FindBy(css = ".Ar.Au div")
    private TextInput mailMessageInput;

    @FindBy(css=".Ha")
    private Button composeWindowCloseButton;


    public ComposePage(WebDriver driver) {
        super(driver);
    }

    public void enterMailTo(String mailTo){
        mailToInput.sendKeys(mailTo);
        log.info("'To' field was filled in.");
    }

    public void enterMailSubject(String mailSubject){
        mailSubjectInput.sendKeys(mailSubject);
        log.info("'Subject' field was filled in.");
    }

    public void enterMailMessage(String mailMessage){
        mailMessageInput.sendKeys(mailMessage);
        log.info("'Mail Text' field was filled in.");
    }

    public void closeComposeWindow(){
        composeWindowCloseButton.click();
        log.info("'Compose' window was closed.");
    }


    public void sendMail(){
        mailMessageInput.sendKeys(Keys.CONTROL,Keys.ENTER);
        log.info("Mail from Draft was sent.");
    }


}
