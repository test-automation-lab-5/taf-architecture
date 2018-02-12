package com.epam.lab5.businessobjects;


import com.epam.lab5.businessobjects.pageobjects.ComposePage;
import com.epam.lab5.testdata.xml.TestDataReader;
import org.openqa.selenium.WebDriver;

public class ComposeBO  {

    private ComposePage composePage;
    private TestDataReader testDataReader=new TestDataReader();

    public ComposeBO(WebDriver driver) {
        composePage= new ComposePage(driver);
    }

    public void composeMail(String mailTo){
        composePage.enterMailTo(mailTo);
        composePage.enterMailSubject(testDataReader.getSubjectFieldValue());
        composePage.enterMailMessage(testDataReader.getMessageFieldValue());
        composePage.closeComposeWindow();
    }

    public void sendMail(){
        composePage.sendMail();
    }
}
