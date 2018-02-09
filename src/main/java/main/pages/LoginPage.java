package main.pages;

import main.pages.decorator.elements.Input;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractGmailPage {

    private static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@type='email' and @class='whsOnd zHQkBf']")
    private Input emailInput;

    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    private Input passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loadLoginPage(String url) {
        log.info("load login page");
        driver.get(url);
    }

    public void enterEmailAndClickNext(String email){
        log.info("enter email and click next");
        emailInput.sendKeys(email + Keys.ENTER);
    }

    public void enterPasswordAndClickNext(String password){
        log.info("enter password and click next");
        passwordInput.sendKeys(password + Keys.ENTER);
    }
}
