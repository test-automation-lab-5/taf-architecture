package epam.com.pomgmail.businessobjects;

import epam.com.pomgmail.pages.GmailLoginPage;
import epam.com.pomgmail.pages.GmailPasswordPage;
import epam.com.pomgmail.pages.ModelProperties;
import org.openqa.selenium.WebDriver;

public class LoginBO {

    private GmailLoginPage loginPage;
    private GmailPasswordPage passwordPage;

    public LoginBO(){
        this.loginPage = new GmailLoginPage();
        this.passwordPage = new GmailPasswordPage();
    }

    public void typeLoginAndPassword(String login, String password){

        loginPage.enterLoginAndSubmit(login);

        passwordPage.enterPasswordAndSubmit(password);
    }

}
