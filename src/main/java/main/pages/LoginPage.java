package main.pages;

import main.pages.decorator.elements.Input;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractGmailPage {

    @FindBy(xpath = "//input[@type='email' and @class='whsOnd zHQkBf']")
    private Input emailInput;

    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    private Input passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loadLoginPage(String url) {
        driver.get(url);
    }

    public void enterEmailAndClickNext(String email) {
        emailInput.sendKeys(email + Keys.ENTER);
    }

    public void enterPasswordAndClickNext(String password) {
        passwordInput.sendKeys(password + Keys.ENTER);
    }
}
