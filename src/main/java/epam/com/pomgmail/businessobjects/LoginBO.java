package epam.com.pomgmail.businessobjects;

import epam.com.pomgmail.pages.GmailLoginPage;
import epam.com.pomgmail.pages.GmailPasswordPage;
import epam.com.pomgmail.pages.ModelProperties;
import org.openqa.selenium.WebDriver;

public class LoginBO {

    ModelProperties model = new ModelProperties();
    GmailLoginPage loginPage = new GmailLoginPage();
    GmailPasswordPage passwordPage = new GmailPasswordPage();

    public void typeLoginAndPassword(WebDriver driver){
        model.setProperties();

//        loginPage.initElements(driver);
        loginPage.enterLoginAndSubmit(model.getLogin());

//        passwordPage.initElements(driver);
        passwordPage.enterPasswordAndSubmit(model.getPassword());
    }

}
