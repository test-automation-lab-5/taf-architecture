package com.epam.lab.businessObjects;

import com.epam.lab.decorator.MyButton;
import com.epam.lab.decorator.MyDecorator;
import com.epam.lab.decorator.MyTextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PasswordPage {
    /*1 Work with WebElement(s) ONLY inside page-object classes
2 Try to use abstract class while implementing page-objects
3 Use TestNG instead JUnit
4 Consider using one of GoF petterns for creating driver instance(s)
5 Tests should be triggered from command line with "mvn clean test" command (Surefire plugin could be used for these purposes
 http://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html)*/


    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private MyTextInput passwordInput;

    @FindBy(xpath = "//span[text()='Next']")
    private MyButton nextButton;


    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(new MyDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
        nextButton.click();
    }


}

