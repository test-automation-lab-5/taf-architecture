package task3.assertions;

import org.testng.Assert;
import task3.pages.SentMessagePage;

public class Assertion {
    private SentMessagePage sentMessagePage = new SentMessagePage();
    public void verifyMessageAbsentsByReceiver(String receiver) {
        Assert.assertFalse(sentMessagePage.isMessagePresent(receiver));
    }
    public void verifyMessagePresenceByReceiver(String receiver) {
        Assert.assertTrue(sentMessagePage.isMessagePresent(receiver));
    }
}
