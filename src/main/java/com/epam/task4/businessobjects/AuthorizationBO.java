package com.epam.task4.businessobjects;

import com.epam.task4.businessobjects.pageobjects.LoginPage;

public class AuthorizationBO{
    public AuthorizationBO authorizeAs(String userMail, String userPassword) {
        new LoginPage()
                .openPage()
                .typeMail(userMail)
                .typePassword(userPassword);
        return this;
    }
}