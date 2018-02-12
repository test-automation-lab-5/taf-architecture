package edu.epam.seleniumexample.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class LettersPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href,'https://mail.google.com/mail/u/0/#inbox')]")
    private WebElement inboxLink;

    @FindBy(xpath = "//a[contains(@href,'https://mail.google.com/mail/u/0/#imp')]")
    private WebElement importantLink;

    @FindBy(xpath ="//span[contains(@class,'CJ')]")
    private WebElement moreLabelLink;

    @FindBy(xpath = "//a[contains(@href,'https://mail.google.com/mail/u/0/#trash')]")
    private WebElement trashLink;

    @FindBy(xpath = "//div[@role='tabpanel']//td[descendant::div[contains(@class,'a9q')]]")
    private List<WebElement> inboxSignList;

    @FindBy(xpath = "//div[@role='tabpanel']//span[contains(@class,'bog')]")
    private List<WebElement> inboxAllLetterTitleList;

    @FindBy(xpath = "//div[@role='tabpanel']//tr[descendant::div/@class='pH a9q']//span[contains(@class,'bog')]")
    private List<WebElement> inboxMarkedLetterTitleList;

    @FindBy(xpath = "//div[contains(@role,'main')]//tr[descendant::div/@class='pH a9q']//span[contains(@class,'bog')]")
    private List<WebElement> importantLetterTitleList;

    @FindBy(xpath = "//div[contains(@role,'main')]//table//div[@role='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@id=':87' and @role='button']")
    private WebElement selectButton;

    @FindBy(xpath = "//div[@selector='all' and @role='menuitem']")
    private WebElement selectAllLabel;

    @FindBy(xpath = "//div[descendant::div[@class='asa'] and @role='button' and @id=':88']")
    private WebElement moveToButton;

    @FindBy(xpath = "//div[@act='8' and @role='menuitem']")
    private WebElement inboxDestinationLabel;

    public LettersPage() {
    }

    public void markInboxLettersAsImportant(Integer quantity) {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfAllElements(inboxSignList));

        for (int i = 0; i < quantity; i++) {
            WebElement sign = inboxSignList.get(i);
                if (!sign.isDisplayed()) {
                    new Actions(driver).moveToElement(sign).perform();
                }
            try{
                sign.click();
            } catch (Exception e){
                new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
                new Actions(driver).sendKeys(Keys.ARROW_UP).perform();
                new Actions(driver).moveToElement(sign).perform();
                sign.click();
            }

        }
    }

    public List<String> getInboxMarkedTitles() {
        List<String> markedTitles = new ArrayList<String>();
        for (WebElement item : inboxMarkedLetterTitleList) {
            markedTitles.add(item.getText());
        }
        return markedTitles;
    }

    public List<String> getImportantLetterTitles() {

        WebDriverWait wait;
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(importantLetterTitleList));

        List<String> importantLetterTitles = new ArrayList<String>();
        for (int i = 0; i < importantLetterTitleList.size(); i++) {
            importantLetterTitles.add(importantLetterTitleList.get(i).getText());
        }
        return importantLetterTitles;
    }

    public void clickInboxLink() {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(inboxLink));
        inboxLink.click();
    }

    public void clickImportantLink() {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(importantLink));
        importantLink.click();
    }
    public void clickTrashLink(){
        if(!trashLink.isDisplayed()){
            new Actions(driver).moveToElement(moreLabelLink).perform();
            moreLabelLink.click();
        }
        trashLink.click();
    }


    public void clickCheckBoxes() {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(checkboxes));
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
    }

    public void clickDeleteButton() {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
    }

    public List<String> getInboxTitles() {

        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(inboxAllLetterTitleList));

        List<String> inboxTitles = new ArrayList<String>();
        for (WebElement item : inboxAllLetterTitleList) {
            inboxTitles.add(item.getText());
        }
        return inboxTitles;
    }

    public void clickSelectButton(){
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(selectButton));
        selectButton.click();
    }

    public void selectAllLetters(){
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(selectAllLabel));
        selectAllLabel.click();
    }
    public void clickMoveToButton(){
        moveToButton.click();
    }
    public void selectInboxDestination(){
        inboxDestinationLabel.click();
    }
}
