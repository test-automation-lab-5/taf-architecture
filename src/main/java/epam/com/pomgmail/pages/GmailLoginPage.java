package epam.com.pomgmail.pages;

import epam.com.pomgmail.pomdecorator.Button;
import epam.com.pomgmail.pomdecorator.InitElements;
import epam.com.pomgmail.pomdecorator.TextInput;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@type,'email')]")
    private TextInput loginInput;

    @FindBy(id = "identifierNext")
    private Button btnNext;

    public void enterLoginAndSubmit(String login){
        loginInput.sendKeys(login);
        btnNext.click();
    }
}
