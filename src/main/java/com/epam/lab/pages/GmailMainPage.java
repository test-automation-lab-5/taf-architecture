package com.epam.lab.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailMainPage extends DefaultPage{

    @FindBy(xpath = ".//*[@role='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//div[@act='10']")
    private WebElement deleteButton;

    @FindBy(xpath = ".//*[@id='link_undo']")
    private WebElement undoButton;

    @FindBy(xpath = ".//*[@class='bofITb']")
    private WebElement messageCanceled;

    @FindBy(xpath = "//*[@class='bog']")
    private List<WebElement> subjects;


    public GmailMainPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void selectCheckboxes(int quantity) {
        for (int i = 1; i < quantity + 1; i++) {
            if (!checkboxes.get( i ).isSelected()) {
                checkboxes.get( i ).click();
            }
        }
    }

    public void deleteEmails() {
        waitToBeClickable( deleteButton );
        deleteButton.click();
    }

    public void undoDeleting() {
        undoButton.click();
    }

    public void waitForDeleteCanceledMessage() {
        waitToBeClickable( messageCanceled );

    }
    public int expectedResult(String subject) {
        int expectedResult = 0;

        for (WebElement el : subjects) {
            if (el.getText().equals( subject )) {
                expectedResult = 1;
            }
        }
        return expectedResult;
    }

    public String firstEmailSubject(){
        return subjects.get( 0 ).getText();

    }



}