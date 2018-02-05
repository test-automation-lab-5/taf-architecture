package main.businessobjects;

import main.Driver;
import main.pages.LoginPage;
import properties.DataProp;

public class LoginPageBusinessObject {

    public void login(DataProp dataProp) {
        LoginPage loginPage = new LoginPage(Driver.getInstance());
        loginPage.loadLoginPage(dataProp.getURL());
        loginPage.enterEmailAndClickNext(dataProp.getMail());
        loginPage.enterPasswordAndClickNext(dataProp.getPassword());
    }
}
