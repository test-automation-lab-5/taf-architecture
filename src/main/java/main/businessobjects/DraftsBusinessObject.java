package main.businessobjects;

import main.Driver;
import main.domparser.xmlmodels.MessageData;
import main.pages.DraftsPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DraftsBusinessObject {
    DraftsPage draftsPage = new DraftsPage(Driver.getDriver());
    public void openDrafts(String subject) {
        draftsPage.openDrafts();
        draftsPage.waitForDraftsLoad();
        draftsPage.openLetterFromDraftsWithSameSubject(subject);
    }

    public void openUserAlert() {
        draftsPage.openProfileAlert();
        draftsPage.clickLogOut();
    }
}
