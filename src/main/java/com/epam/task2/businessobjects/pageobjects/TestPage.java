package com.epam.task2.businessobjects.pageobjects;

import com.epam.task2.businessobjects.pageobjects.decorator.elements.heandlers.MyPageFactory;
import com.epam.task2.businessobjects.pageobjects.decorator.elements.InputField;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class TestPage extends AbstractPage {
    private static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@type='email']")
    private InputField mailField;

    public TestPage() {
        super(new MyPageFactory());
    }

    public TestPage openPage() {
        log.info("Open login page");
        openPage("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        return this;
    }

    public TestPage typeMail(String mail) {
        log.info("Type mail");
        mailField.sendKeys(String.format("%s\n", mail));
        return this;
    }

    public boolean varifyTextTyped() {
        return !mailField.getValue().equals("");
    }
}