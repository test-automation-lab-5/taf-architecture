package com.epam.lab5.businessobjects;


import com.epam.lab5.pageobjects.DraftsPage;
import com.epam.lab5.testdata.TestDataReader;
import org.openqa.selenium.WebDriver;

public class DraftsBO  {

    private DraftsPage draftsPage;
    private TestDataReader testDataReader=new TestDataReader();

    public DraftsBO(WebDriver driver) {
        draftsPage=new DraftsPage(driver);
    }

    public void openDrafts(){
        draftsPage.openDraftsPage();
    }

    public String getDraftMailSubject(){
       return draftsPage.getDraftMailWithSubject(testDataReader.getSubjectFieldValue()).getText();
    }

    public void openDraftMailWithSubject(){
        draftsPage.clickDraftMailWithSubject(testDataReader.getSubjectFieldValue());
    }

    public boolean isElementDisplayed(){
        return draftsPage.isMailWasSentWindowDisplayed();
    }
}
