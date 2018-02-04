package com.epam.task2.businessobjects;

import com.epam.task2.businessobjects.pageobjects.LoginPage;

public class AuthorizationBO implements BusinessObjects{
    public AuthorizationBO authorizeAs(String userMail, String userPassword) {
        new LoginPage()
                .openPage()
                .typeMail(userMail)
                .typePassword(userPassword);
        return this;
    }
}