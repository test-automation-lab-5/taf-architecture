package com.epam.lab.facadetask.decorator.bo.businessobjects;

import com.epam.lab.facadetask.decorator.bo.pages.LoginPage;

public class Login {

    private LoginPage loginPage = new LoginPage();

    public Login() {}

    public void login(String login, String password)  {
        loginPage.login(login);
        loginPage.setPassword(password);
        loginPage.openGmail();
    }

}