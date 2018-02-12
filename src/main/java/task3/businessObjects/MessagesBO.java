package task3.businessObjects;
import task3.pages.InboxMessagePage;
import task3.pages.SentMessagePage;
import task3.pages.WriteMessagePage;

public class MessagesBO {
    private SentMessagePage sentMessagePage = new SentMessagePage();
    public void createNewMessage() {
        InboxMessagePage inboxMessagePage = new InboxMessagePage();
        inboxMessagePage.clickmessage();
    }
    public void typeMessageDataAndSend(String receiver, String subject, String content) {
        WriteMessagePage writeMessageBox = new WriteMessagePage();
        writeMessageBox.typeMessage(receiver, subject, content);
        sentMessagePage.clicklinkSentMessage();
    }
    public void deleteMessage() throws InterruptedException {
        Thread.sleep(1000);
        sentMessagePage.getcheckboxVisible();
        sentMessagePage.clickDelete();
    }
}
