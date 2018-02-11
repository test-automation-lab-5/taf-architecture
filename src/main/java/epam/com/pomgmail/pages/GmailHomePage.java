package epam.com.pomgmail.pages;

import epam.com.pomgmail.jaxb.RetrieveUsersData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GmailHomePage extends AbstractPage {

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

    private List<String> titleList;
    private int count = RetrieveUsersData.getXMLComponent();

    public void setMessageImportant() throws InterruptedException {
        WebDriverWait wait;
        wait = new WebDriverWait(CreateDriver.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(importantOne));
        importantOne.click();
        importantTwo.click();
        importantThree.click();
    }

    public List<String> getInboxSubject(){
        (new WebDriverWait(CreateDriver.getInstance().getDriver(), 20))
                .until(ExpectedConditions.visibilityOfAllElements(inboxesSubject));
        titleList = new ArrayList<>();
        for (int i = 0; i < count; i++){
            titleList.add(inboxesSubject.get(i).getText());
        }
        return titleList;
    }

    public void clickImportantLink() throws InterruptedException {
        Thread.sleep(3000);
        importantLink.click();
    }

    public void checkMessages() throws InterruptedException {
        Thread.sleep(2000);
        (new WebDriverWait(CreateDriver.getInstance().getDriver(), 20))
                .until(ExpectedConditions.visibilityOfAllElements(checkboxes));

        checkboxes.stream().limit(count).forEach(checkboxes -> checkboxes.click());
    }

    public boolean getImportantSubject() {
        WebDriverWait wait;
        wait = new WebDriverWait(CreateDriver.getInstance().getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(importantSubject));

        List<String> verifiesList = new ArrayList<>();

        for (WebElement anImportantSubject : importantSubject) {
            verifiesList.add(anImportantSubject.getText());
        }
        return verifiesList.containsAll(titleList);
    }

    public void clickDeleteAndMoreLinks(){
        deleteBtn.click();
        moreBtn.click();
    }

    public void clickTrashLink(){
        WebDriverWait wait;
        wait = new WebDriverWait(CreateDriver.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(trashBtn));
        trashBtn.click();
    }

    public List<String> getDeletedSubject(){
        WebDriverWait wait;
        wait = new WebDriverWait(CreateDriver.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(deleteSubject));
        List<String> deletedList = new ArrayList<>();
        for (WebElement aDeleteSubject : deleteSubject) {
            deletedList.add(aDeleteSubject.getText());
        }
        return deletedList;
    }
}
