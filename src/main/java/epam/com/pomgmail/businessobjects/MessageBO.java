package epam.com.pomgmail.businessobjects;

import epam.com.pomgmail.pages.GmailHomePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MessageBO {

    GmailHomePage homePage = new GmailHomePage();
    List<String> titleList;

    public void interactionWithMessages(WebDriver driver) {
        homePage.setMessageImportant();
        titleList = homePage.getInboxSubject(driver);
    }

    public void checkImportantMessages(WebDriver driver) throws InterruptedException {
        homePage.clickImportantLink();
        homePage.checkMessages(driver);
    }

    public boolean verifyImportantMessages(WebDriver driver){
        return homePage.getImportantSubject(driver);
    }

    public void deleteCheckedMessages(WebDriver driver){
        homePage.clickDeleteAndMoreLinks();
        homePage.clickTrashLink(driver);
    }

    public boolean verifyIsMessagesDeleted(WebDriver driver){
        List<String> deletedList = homePage.getDeletedSubject(driver);
        return (deletedList.containsAll(titleList)) ? true : false;
    }
}
