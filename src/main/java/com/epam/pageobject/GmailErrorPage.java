package com.epam.pageobject;

import com.epam.decorator.*;
import org.openqa.selenium.support.FindBy;

public class GmailErrorPage extends AbstractPage{



    @FindBy(css = "div[class='Kj-JD-Jz']")
    private Label alertMessage;


    @FindBy(css = "button[name='ok']")
    private Button okButton;


    public String getAlertMessage (){

        return alertMessage.getText();

    }

    public void pressOkButton (){

        waitUntilBeClickable(okButton);
        okButton.clickOn();

    }
}
