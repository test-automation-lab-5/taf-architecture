package com.epam.lab.facadetask.decorator.bo.businessobjects;

import com.epam.lab.facadetask.testdata.model.User;
import com.epam.lab.facadetask.decorator.bo.pages.LoginPage;

public class Login {

    private LoginPage loginPage = new LoginPage();

    public Login() {}

    public void login(User user)  {
        typeLoginAndSubmit(user.getEmail());
        typePasswordAndSubmit(user.getPassword());
        loginPage.getGmailPage().click();
    }

    private void typeLoginAndSubmit(String login) {
        loginPage.getEmailInput().sendKeys(login);
        loginPage.getEmailNext().click();
    }

    private void typePasswordAndSubmit(String password) {
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getPasswordNext().click();
    }
}