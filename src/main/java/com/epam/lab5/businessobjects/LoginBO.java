package com.epam.lab5.businessobjects;

import com.epam.lab5.pageobjects.LoginPage;
import com.epam.lab5.logindata.LoginDataReader;
import com.epam.lab5.propdata.DriverDataReader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginBO  {

    private LoginPage loginPage;
    private DriverDataReader driverDataReader = new DriverDataReader();

    public LoginBO(WebDriver driver) throws IOException {
        loginPage=new LoginPage(driver);
    }

    public void login(String eMail,String password){
        loginPage.enterEmail(eMail);
        loginPage.enterPassword(password);
    }
}
