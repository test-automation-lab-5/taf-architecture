package main.businessobjects;

import main.Driver;
import main.LetterWindowPageBusinessObject;
import main.pages.DraftsPage;
import properties.DataProp;

import java.io.IOException;

public class DraftsBusinessObject {

    public void openDrafts(DataProp dataProp) throws IOException {
        DraftsPage draftsPage = new DraftsPage(Driver.getInstance());

        draftsPage.openDrafts();
        draftsPage.waitForDraftsLoad();
        draftsPage.openLetterFromDraftsWithSameSubject(LetterWindowPageBusinessObject.getSubject());
    }
}
