package epam.com.pomgmail.pages;

import epam.com.pomgmail.pomdecorator.Button;
import epam.com.pomgmail.pomdecorator.TextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPasswordPage extends AbstractPage {

    public GmailPasswordPage(){

    }

    @FindBy(xpath = "//input[@name='password']")
    private TextInput passwordInput;

    @FindBy(id = "passwordNext")
    private Button buttonNext;

    public void enterPasswordAndSubmit(String password){
        passwordInput.sendKeys(password);
        buttonNext.click();
    }
}
