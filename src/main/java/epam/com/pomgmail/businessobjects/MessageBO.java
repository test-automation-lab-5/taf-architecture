package epam.com.pomgmail.businessobjects;

import epam.com.pomgmail.pages.GmailHomePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MessageBO {

    GmailHomePage homePage = new GmailHomePage();
    List<String> titleList;

    public void interactionWithMessages(WebDriver driver) throws InterruptedException {
        homePage.setMessageImportant();
        titleList = homePage.getInboxSubject(driver);
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
        if (deletedList.containsAll(titleList))
            return true;
        else
            return false;
    }
}
