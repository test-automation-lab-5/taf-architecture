package main.pages;

import main.pages.decorator.elements.Button;
import main.pages.decorator.elements.Input;
import main.pages.decorator.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractGmailPage {

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
        drafts.click();
    }

    public void waitForDraftsLoad() {
        waitUntilTextToBePresentInElement(googleSearchInput, "in:draft ");
    }

    public void openLetterFromDraftsWithSameSubject(String subject) {
        WebElement letter = driver.findElement(By.xpath("//table[@cellpadding='0']/tbody/tr/td[@class='xY a4W']/div/div/div/span[text()='" + subject + "']"));
        letter.click();
    }

    public void openProfileAlert() {
        profileButton.click();
    }

    public void clickLogOut() {
        signOut.click();
        if (waitUntilAlertBePresent()) {
            driver.switchTo().alert().accept();
        }
        waitUntilUrlWillContains("accounts");
    }
}
