package edu.epam.seleniumexample.businessobjects;

import edu.epam.seleniumexample.pages.LoginPage;
import edu.epam.seleniumexample.pages.MainPage;
import edu.epam.seleniumexample.pages.PasswordPage;
import edu.epam.seleniumexample.utils.BrowserDriver;
import edu.epam.seleniumexample.utils.PropertyContainer;

public class LoginBO {
    private MainPage mainPage;
    private LoginPage loginPage;
    private PasswordPage passwordPage;

    public LoginBO() {
        this.mainPage = new MainPage();
        this.loginPage = new LoginPage();
        this.passwordPage = new PasswordPage();
    }
     public void loginUser(String login, String password){
        mainPage.clickSignInButton();
        loginPage.enterLogin(login);
        passwordPage.enterPassword(password);
     }

}
