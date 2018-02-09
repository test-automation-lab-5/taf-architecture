package com.epam.lab5.pageobjects;

import com.epam.lab5.decorator.elements.PageElement;
import com.epam.lab5.decorator.elements.TextInput;
import com.epam.lab5.driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(name = "identifier")
    private TextInput emailInput;

    @FindBy(name="password")
    private TextInput passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(String loginPageLink){
        DriverFactory.getInstance().getDriver().get(loginPageLink);
        log.info("Link was got.");
    }

    public void enterEmail(String email){
        emailInput.sendKeys(email+Keys.ENTER);
        log.info("eMail was submited.");
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password+Keys.ENTER);
        log.info("Password was submited.");
    }
}
