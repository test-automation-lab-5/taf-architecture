package com.epam.lab.pages;


import com.epam.lab.elements.Button;
import com.epam.lab.elements.CheckBox;
import com.epam.lab.elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class GmailMainPage extends DefaultPage {

    @FindBy(xpath = ".//*[@role='checkbox']")
    private List<CheckBox> checkboxes;

    @FindBy(xpath = "//div[@act='10']")
    private Button deleteButton;

    @FindBy(xpath = ".//*[@id='link_undo']")
    private Button undoButton;

    @FindBy(xpath = ".//*[@class='bofITb']")
    private Element messageCanceled;

    @FindBy(xpath = "//*[@class='bog']")
    private List<Element> subjects;


    public GmailMainPage(WebDriver webDriver) {

        super( webDriver );
        Assert.assertTrue( checkboxes.get( 1 ).isDisplayed() );
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

        for (Element el : subjects) {
            if (el.getText().equals( subject )) {
                expectedResult = 1;
            }
        }
        return expectedResult;
    }

    public String firstEmailSubject() {
        return subjects.get( 0 ).getText();

    }


}