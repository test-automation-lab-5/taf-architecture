package main.pages;

import main.pages.decorator.elements.Button;
import main.pages.decorator.elements.Input;
import main.pages.decorator.elements.Link;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class DraftsPage extends AbstractGmailPage {

    private static final Logger LOG = Logger.getLogger(DraftsPage.class);

    @FindBy(xpath = "//a[contains(@href, '#drafts')]")
    private Link drafts;

    @FindBy(xpath = "//input[@name='q']")
    private Input googleSearchInput;

    @FindBy(xpath = "//a[@class='gb_b gb_fb gb_R' and @role='button' and contains(@title, 'Google Account:')]")
    private Button profileButton;

    @FindBy(xpath = "//a[@class='gb_Ea gb_Sf gb_0f gb_He gb_Eb' and contains(@href, 'Logout')]")
    private Button signOut;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public void openDrafts() {
        LOG.info("Click on \"drafts\"");
        drafts.click();
    }

    public void waitForDraftsLoad() {
        waitUntilTextToBePresentInElement(googleSearchInput, "in:draft ");
    }

    public void openLetterFromDraftsWithSameSubject(String subject) {
        LOG.info("find necessary letter in drafts");
        WebElement letter = driver.findElement(By.xpath("//table[@cellpadding='0']/tbody/tr/td[@class='xY a4W']/div/div/div/span[text()='" + subject + "']"));
        LOG.info("click on this message");
        letter.click();
    }

    public void openProfileAlert() {
        profileButton.click();
    }

    public void clickLogOut() {
        signOut.click();
        if (waitUntilAlertBePresent()){
            driver.switchTo().alert().accept();
        }
        waitUntilUrlWillContainsAccounts();
    }
}
