package com.epam.lab5.businessobjects;

import com.epam.lab5.pageobjects.InboxPage;
import org.openqa.selenium.WebDriver;

public class InboxBO  {

    private InboxPage inboxPage;

    public InboxBO(WebDriver driver) {
        inboxPage=new InboxPage(driver);
    }

    public void openComposeWindow(){
        inboxPage.clickComposeButton();
    }
}
