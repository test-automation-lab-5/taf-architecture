package epam.com.pomgmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GmailHomePage extends AbstractPage {

    public GmailHomePage(){

    }

    @FindBy(xpath="//div[contains(@class, 'UI')]//table//tr[1]//td[4]")
    private WebElement importantOne;

    @FindBy(xpath="//div[contains(@class, 'UI')]//table//tr[2]//td[4]")
    private WebElement importantTwo;

    @FindBy(xpath="//div[contains(@class, 'UI')]//table//tr[3]//td[4]")
    private WebElement importantThree;

    @FindBy(xpath="//div[contains(@class, 'UI')]//table//tr//td//div[contains(@aria-label, 'Not important')]")
    private List<WebElement> importants;

    @FindBy(xpath="//div[contains(@role, 'tabpanel')]//span[contains(@class, 'bog')] | " +
            "//div[contains(@role, 'tabpanel')]//span[contains(@class, 'bog')]//b")
    private List<WebElement> inboxesSubject;

    @FindBy(xpath="//div[@class='TK']//a[contains(@href, 'imp')]")
    private WebElement importantLink;

    @FindBy(xpath="//div[contains(@class, 'AO')]//div[@role='main']//div[@role='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath="//div[contains(@role, 'main')]//span[contains(@class, 'bog')] | //div[contains(@role, 'main')]//span[contains(@class, 'bog')]//b")
    private List<WebElement> importantSubject;

    @FindBy(xpath="//div[@gh='mtb']//div[@act='10']")
    private WebElement deleteBtn;

    @FindBy(xpath="//span[contains(@gh, 'mll')]")
    private WebElement moreBtn;

    @FindBy(xpath="//div[@class='TK']//a[contains(@href, 'trash')]")
    private WebElement trashBtn;

    @FindBy(xpath="//div[@role='main']//div[contains(@gh, 'tl')]//span[contains(@class, 'bog')] | div[@role='main']//div[contains(@gh, 'tl')]//span[contains(@class, 'bog')]//b")
    private List<WebElement> deleteSubject;

    List<String> titleList;

    public void setMessageImportant(){
//        for (int i = 0; i < 3; i++){
//            importants.get(i).click();
//        }
        importantOne.click();
        importantTwo.click();
        importantThree.click();
    }

    public List<String> getInboxSubject(WebDriver driver){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElements(inboxesSubject));
        titleList = new ArrayList<>();
        if(inboxesSubject.size() >= 3){
            for (int i = 0; i < 3; i++){
                titleList.add(inboxesSubject.get(i).getText());
            }
        }
        return titleList;
    }

    public void clickImportantLink() {
        importantLink.click();
    }

    public void checkMessages(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfAllElements(checkboxes));
        for (int i = 0; i < 3; i++){
            checkboxes.get(i).click();
        }
    }

    public boolean getImportantSubject(WebDriver driver) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(importantSubject));

        List<String> verifiesList = new ArrayList<>();

        for (int i = 0; i < importantSubject.size(); i++){
            verifiesList.add(importantSubject.get(i).getText());
        }
        if (verifiesList.containsAll(titleList))
            return true;
        else
            return false;
    }

    public void clickDeleteAndMoreLinks(){
        deleteBtn.click();
        moreBtn.click();
    }

    public void clickTrashLink(WebDriver driver){
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(trashBtn));
        trashBtn.click();
    }

    public List<String> getDeletedSubject(WebDriver driver){
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(deleteSubject));
        List<String> deletedList = new ArrayList<>();
        for(int i = 0; i < deleteSubject.size(); i++) {
            deletedList.add(deleteSubject.get(i).getText());
        }
        return deletedList;
    }
}
