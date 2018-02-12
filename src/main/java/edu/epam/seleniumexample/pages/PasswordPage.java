package edu.epam.seleniumexample.pages;

import edu.epam.seleniumexample.utils.BrowserDriver;
import edu.epam.seleniumexample.utils.PropertyContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement passwordEnterButton;

    public PasswordPage() {
    }

    public void enterPassword(String password) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(passwordEnterButton));
        passwordEnterButton.click();
    }
}
