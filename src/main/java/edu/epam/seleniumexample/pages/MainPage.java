package edu.epam.seleniumexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement signInButton;

    public MainPage() {
    }

    public void clickSignInButton() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public WebElement getSignInButton() {
        return signInButton;
    }
}
