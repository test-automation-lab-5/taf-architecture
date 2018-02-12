package epam.com.pomgmail.businessobjects;

import epam.com.pomgmail.pages.GmailHomePage;

import java.util.List;

public class MessageBO {

    private GmailHomePage homePage = new GmailHomePage();
    private List<String> titleList;

    public void setMessagesImportant() {
        homePage.setMessageImportant();
        titleList = homePage.getInboxSubject();
    }

    public void checkImportantMessages() throws InterruptedException {
        homePage.clickImportantLink();
        homePage.checkMessages();
    }

    public boolean isMessagesPresentInImportant(){
        return homePage.isSubjectInImportant();
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
