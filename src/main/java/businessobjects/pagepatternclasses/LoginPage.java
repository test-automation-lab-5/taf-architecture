package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.ButtonImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.TextInputImpl;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='identifierId']")
    private TextInputImpl loginInput;
    @FindBy(xpath = "//content[@class='CwaK9']")
    private ButtonImpl loginNextButton;
    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private TextInputImpl passwordInput;
    @FindBy(className = "CwaK9")
    private ButtonImpl passwordNextButton;
    @FindBy(className = "WaidBe")
    private ButtonImpl gmailIcon;

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
