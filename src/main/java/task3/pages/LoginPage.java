package task3.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task3.waiter.Waiter;
import task3.pageElements.Button;
import task3.pageElements.Input;

import java.util.logging.Logger;

public class LoginPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(String.valueOf(LoginPage.class));
    @FindBy(id= "identifierId")
    private Input loginInput;
    @FindBy(id= "identifierNext")
    private Button loginNextButton;
    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private Input passwordInput;
    @FindBy(id= "passwordNext")
    private Button passwordNextButton;

    public void openLoginPage(String loginPageLink) {
        driver.get(loginPageLink);
    }
    public void typeLogin(String login){
        loginInput.sendKeys(login);
        loginNextButton.click();
        log.info("Email entered isMessagePresent");
    }
    public void typePassword(String password){
        Waiter.waitFor(driver,ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
        passwordNextButton.click();
        log.info("Password entered isMessagePresent");
    }
}
