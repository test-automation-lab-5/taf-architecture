package com.epam.lab5.businessobjects;

import com.epam.lab5.pageobjects.LoginPage;
import com.epam.lab5.propdata.LoginDataReader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginBO  {

    private LoginPage loginPage;
    private LoginDataReader loginDataReader=new LoginDataReader();

    public LoginBO(WebDriver driver) throws IOException {
        loginPage=new LoginPage(driver);
    }

    public void login(String email, String password){
        loginPage.openLoginPage(loginDataReader.getMailLink());
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
}
