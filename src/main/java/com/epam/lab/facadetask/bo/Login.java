package com.epam.lab.facadetask.bo;

import com.epam.lab.facadetask.model.User;
import com.epam.lab.facadetask.pages.LoginPage;

import java.io.IOException;

public class Login {

    LoginPage loginPage = new LoginPage();

    public Login() throws IOException {
    }


    public void login(User user)  {
        typeLoginAndSubmit(user.getEmail());
        typePasswordAndSubmit(user.getPassword());
    }

    public void getGmailLocator() {
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