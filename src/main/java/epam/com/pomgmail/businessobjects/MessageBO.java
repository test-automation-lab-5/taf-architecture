package epam.com.pomgmail.businessobjects;

import epam.com.pomgmail.pages.GmailHomePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MessageBO {

    GmailHomePage homePage = new GmailHomePage();
    List<String> titleList;

    public void interactionWithMessages() throws InterruptedException {
        homePage.setMessageImportant();
        titleList = homePage.getInboxSubject();
    }

    public void checkImportantMessages() throws InterruptedException {
        homePage.clickImportantLink();
        homePage.checkMessages();
    }

    public boolean verifyImportantMessages(){
        return homePage.getImportantSubject();
    }

    public void deleteCheckedMessages(){
        homePage.clickDeleteAndMoreLinks();
        homePage.clickTrashLink();
    }

    public boolean isMessagesDeleted(){
        List<String> deletedList = homePage.getDeletedSubject();
        return deletedList.containsAll(titleList);
    }
}
