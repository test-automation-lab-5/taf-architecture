package com.epam.task2.businessobjects.pageobjects;

import com.epam.task2.businessobjects.pageobjects.decorator.elements.heandlers.MyPageFactory;
import com.epam.task2.businessobjects.pageobjects.decorator.elements.Button;
import com.epam.task2.businessobjects.pageobjects.decorator.elements.CheckBox;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MailboxPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(MailboxPage.class);
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private CheckBox visibleCheckbox;
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private List<CheckBox> visibleCheckboxes;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private Button visibleDeleteButton;
    @FindBy(id = "link_undo")
    private Button undoLink;


    public MailboxPage() {
        super(new MyPageFactory());
    }

    public MailboxPage checkFirstNCheckboxesFromCurrentPool(int n) {
        log.info("Check messages from inbox");
        waitUntilBeClickable(visibleCheckbox);
        visibleCheckboxes.stream().limit(Math.min(n, visibleCheckboxes.size())).forEach(CheckBox::click);
        return this;
    }

    public MailboxPage waitMailboxPageLoad() {
        log.info("Wait mailbox load");
        waitPageRedirectToURL("https://mail.google.com/mail/#inbox");
        waitPageLoad();
        return this;
    }

    public MailboxPage clickVisibleDeleteButton() {
        log.info("Click on delete button");
        visibleDeleteButton.click();
        return this;
    }

    public MailboxPage clickUndoLink() {
        log.info("Click on undo button");
        ((Button) waitUntilBeClickable(undoLink)).click();
        return this;
    }

    public MailboxPage waitMessageBeRestored(List<String> deletedIdList) {
        log.info("Verify that messages are not deleted");
        waitUntilTrue(f -> deletedIdList.equals(getIdsOfFirstNMailsFromCurrentPool(deletedIdList.size())));
        return this;
    }

    public List<String> getIdsOfFirstNMailsFromCurrentPool(int n) {
        log.info("List of ids");
        return visibleCheckboxes.stream().limit(Math.min(n, visibleCheckboxes.size()))
                .map(webElement -> webElement.getAttribute("id")).collect(Collectors.toList());
    }
}