package com.epam.pageobject;

import com.epam.decorator.Button;
import com.epam.decorator.IButton;
import com.epam.decorator.ILabel;
import com.epam.decorator.Label;
import com.epam.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailAlertPage extends AbstractPage {

    public GmailAlertPage (WebDriver driver){

        super(driver);
    }


    @FindBy(css = "div[class='Kj-JD-Jz']")
    WebElement alertMessage;


    @FindBy(css = "button[name='ok']")
    WebElement okButton;


    public String getAlertMessage (){

        return alertMessage.getAttribute("innerHTML");


    }

    public void pressOkButton (){

        okButton.click();

    }
}
