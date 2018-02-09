package main.businessobjects;

import main.Driver;
import main.domparser.xmlmodels.User;
import main.pages.LoginPage;
import properties.DataProp;

public class LoginPageBusinessObject {

    public void login(User user) {
        DataProp dataProp = new DataProp();
        LoginPage loginPage = new LoginPage(Driver.getDriver());
        loginPage.loadLoginPage(dataProp.getURL());
        loginPage.enterEmailAndClickNext(user.getEmail());
        loginPage.enterPasswordAndClickNext(user.getPassword());
    }
}
