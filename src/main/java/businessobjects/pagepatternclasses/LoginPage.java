package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.Button;
import businessobjects.pagepatternclasses.decorator.elements.elements.TextInput;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='identifierId']")
    private TextInput loginInput;
    @FindBy(xpath = "//content[@class='CwaK9']")
    private Button loginNextButton;
    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private TextInput passwordInput;
    @FindBy(className = "CwaK9")
    private Button passwordNextButton;
    @FindBy(className = "WaidBe")
    private Button gmailIcon;

    public LoginPage() {
        super(new MyPageFactory());
    }

    public void loginGmail(String login) {
        loginInput.sendKeys(login);
        loginNextButton.click();
    }


    public void setPasswordInput(String password) {
        waitUntilBeClickableAbstract(passwordInput);
        passwordInput.sendKeys(password);
        passwordNextButton.click();
    }

    public void openGmailPage() {
        gmailIcon.click();
    }
}
