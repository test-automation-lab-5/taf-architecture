package com.epam.task4.businessobjects.pageobjects;

import com.epam.task4.businessobjects.pageobjects.decorator.elements.Button;
import com.epam.task4.businessobjects.pageobjects.decorator.elements.CheckBox;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MailBoxPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(MailBoxPage.class);
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private CheckBox visibleCheckbox;
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private List<CheckBox> visibleCheckboxes;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private Button visibleDeleteButton;
    @FindBy(id = "link_undo")
    private Button undoLink;

    public MailBoxPage checkFirstNCheckboxesFromCurrentPool(int n) {
        log.info("Check messages from inbox");
        waitUntilBeClickable(visibleCheckbox);
        visibleCheckboxes.stream().limit(Math.min(n, visibleCheckboxes.size())).forEach(CheckBox::check);
        return this;
    }

    public MailBoxPage waitMailboxPageLoad() {
        log.info("Wait mailbox load");
        waitPageURLEndsWith("#inbox");
        waitPageLoad();
        return this;
    }

    public MailBoxPage clickVisibleDeleteButton() {
        log.info("Click on delete button");
        waitUntilBeClickable(visibleDeleteButton);
        visibleDeleteButton.click();
        return this;
    }

    public MailBoxPage clickUndoLink() {
        log.info("Click on undo button");
        waitUntilBeClickable(undoLink).click();
        return this;
    }

    public MailBoxPage waitMessageBeRestored(List<String> deletedIdList) {
        log.info("Verify that messages are not deleted");
        waitUntilTrue(f -> deletedIdList.equals(getIdsOfFirstNMailsFromCurrentPool(deletedIdList.size())));
        return this;
    }

    public List<String> getIdsOfFirstNMailsFromCurrentPool(int n) {
        log.info("Get list of ids");
        return visibleCheckboxes.stream().limit(Math.min(n, visibleCheckboxes.size()))
                .map(webElement -> webElement.getAttribute("id")).collect(Collectors.toList());
    }
}