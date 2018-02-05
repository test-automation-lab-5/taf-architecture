package main.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class DraftsPage extends AbstractGmailPage {

    private static final Logger log = Logger.getLogger(DraftsPage.class);

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/#drafts']")
    private WebElement drafts;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement googleSearchInput;

    public DraftsPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void openDrafts() {
        log.info("Click on \"drafts\"");
        drafts.click();
    }

    public void waitForDraftsLoad() {
        waitUntilTextToBePresentInElement(googleSearchInput, "in:draft ");
    }

    public void openLetterFromDraftsWithSameSubject(String subject) {
        log.info("find necessary letter in drafts");
        WebElement letter = driver.findElement(By.xpath("//table[@cellpadding='0']/tbody/tr/td[@class='xY a4W']/div/div/div/span[text()='" + subject + "']"));
        log.info("click on this message");
        letter.click();
    }
}
