package epam.com.pomgmail.pages;

import epam.com.pomgmail.pomdecorator.Button;
import epam.com.pomgmail.pomdecorator.InitElements;
import epam.com.pomgmail.pomdecorator.TextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage extends AbstractPage {

    public GmailLoginPage() {
        super(new InitElements());
    }

    @FindBy(xpath = "//input[contains(@type,'email')]")
    private TextInput loginInput;

    @FindBy(id = "identifierNext")
    private Button btnNext;

    public void enterLoginAndSubmit(String login){
        System.out.println(loginInput);
        loginInput.sendKeys(login);
        btnNext.click();
    }
}
