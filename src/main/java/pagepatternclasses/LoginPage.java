package pagepatternclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement loginInput;
    @FindBy(xpath = "//content[@class='CwaK9']")
    private WebElement loginNextButton;
    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement passwordInput;
    @FindBy(className = "CwaK9")
    private WebElement passwordNextButton;
    @FindBy(className = "WaidBe")
    private WebElement gmailIcon;

    public void loginGmail(String login) {
        loginInput.sendKeys(login);
        loginNextButton.click();
    }



    public void setPasswordInput(String password) {
        waitUntilBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        passwordNextButton.click();
    }

    public void openGmailPage() {
        gmailIcon.click();
    }
}
