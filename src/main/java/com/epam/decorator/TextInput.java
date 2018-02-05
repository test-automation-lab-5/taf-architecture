package com.epam.decorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextInput extends  AbstractElement implements ITextInput {

    public TextInput(WebElement webElement) {

        super(webElement);
    }

    public void enterText(String string){
        //логіка очікування
        getWrappedElement().sendKeys(string);
    }
}
