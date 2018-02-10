package main.businessobjects;

import main.driver.Driver;
import main.domparser.xmlmodels.User;
import main.pages.LoginPage;
import properties.DataProp;

public class LoginBusinessObject {

    public void login(User user) {
        DataProp dataProp = new DataProp();
        LoginPage loginPage = new LoginPage(Driver.getDriver());
        loginPage.loadLoginPage(dataProp.getURL());
        loginPage.enterEmailAndClickNext(user.getEmail());
        loginPage.enterPasswordAndClickNext(user.getPassword());
    }
}
