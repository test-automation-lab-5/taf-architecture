package com.epam.lab5.businessobjects;

import com.epam.lab5.businessobjects.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginBO  {

    private LoginPage loginPage;

    public LoginBO(WebDriver driver) throws IOException {
        loginPage=new LoginPage(driver);
    }

    public void login(String eMail,String password){
        loginPage.enterEmail(eMail);
        loginPage.enterPassword(password);
    }
}
