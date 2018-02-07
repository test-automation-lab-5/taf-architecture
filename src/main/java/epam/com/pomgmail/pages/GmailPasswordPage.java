package epam.com.pomgmail.pages;

import epam.com.pomgmail.pomdecorator.Button;
import epam.com.pomgmail.pomdecorator.InitElements;
import epam.com.pomgmail.pomdecorator.TextInput;
import org.openqa.selenium.support.FindBy;

public class GmailPasswordPage extends AbstractPage {

    public GmailPasswordPage(){
        super(new InitElements());
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
