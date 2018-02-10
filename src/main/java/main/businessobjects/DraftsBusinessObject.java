package main.businessobjects;

import main.driver.Driver;
import main.pages.DraftsPage;

public class DraftsBusinessObject {
    private DraftsPage draftsPage = new DraftsPage(Driver.getDriver());
    public void openDrafts(String subject) {
        draftsPage.openDrafts();
        draftsPage.waitForDraftsLoad();
        draftsPage.openLetterFromDraftsWithSameSubject(subject);
    }

    public void logOut() {
        draftsPage.openProfileAlert();
        draftsPage.clickLogOut();
    }
}
