package task3.businessObjects;
import task3.constants.Constants;
import task3.pages.LoginPage;
import task3.properties.WebDriverData;
import task3.xml.User;


import java.io.IOException;
public class LoginBO {
    public void testlogin(String email , String password) {
        WebDriverData webDriverData = new WebDriverData();
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(webDriverData.getDriver("url"));
        loginPage.typeLogin(email);
        loginPage.typePassword(password);
    }
}
