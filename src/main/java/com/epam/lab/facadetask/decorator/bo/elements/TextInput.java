package com.epam.lab.facadetask.decorator.bo.elements;

import org.openqa.selenium.WebElement;

public class TextInput extends AbstractElement {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String input){
        webElement.sendKeys(input);
    }


    public String getInput(){
        return webElement.getText();
    }
}
