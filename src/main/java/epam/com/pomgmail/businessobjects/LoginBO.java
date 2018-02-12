package epam.com.pomgmail.businessobjects;

import epam.com.pomgmail.jaxb.User;
import epam.com.pomgmail.pages.GmailLoginPage;
import epam.com.pomgmail.pages.GmailPasswordPage;
import epam.com.pomgmail.pages.ModelProperties;
import org.openqa.selenium.WebDriver;

public class LoginBO {

    private GmailLoginPage loginPage = new GmailLoginPage();
    private GmailPasswordPage passwordPage = new GmailPasswordPage();

    public void login(User users){

        loginPage.enterLoginAndSubmit(users.getLogin().trim());

        passwordPage.enterPasswordAndSubmit(users.getPassword().trim());
    }

}
