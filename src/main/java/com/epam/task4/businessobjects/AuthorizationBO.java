package com.epam.task4.businessobjects;

import com.epam.task4.businessobjects.pageobjects.LoginPage;
import com.epam.task4.testdata.TestData;

public class AuthorizationBO{
    public AuthorizationBO authorizeAs(TestData testData) {
        new LoginPage()
                .openPage()
                .typeMail(testData.getUserMail())
                .typePassword(testData.getUserPassword());
        return this;
    }
}