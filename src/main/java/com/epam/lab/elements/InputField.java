package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public class InputField extends Element{
    public InputField(WebElement webElement) {
        super( webElement );
    }
    public void sendKeys (String message){
        webElement.sendKeys( message );
    }
}
