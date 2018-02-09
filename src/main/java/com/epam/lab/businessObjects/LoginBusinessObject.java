package com.epam.lab.businessObjects;

import org.openqa.selenium.WebDriver;


public class LoginBusinessObject {
    private LoginPage loginPage;
    private PasswordPage passwordPage;

    public LoginBusinessObject(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.passwordPage = new PasswordPage(driver);
    }

    public void loginUser(String login, String password) {
        loginPage.typeLogin(login);
        passwordPage.typePassword(password);
    }
}
