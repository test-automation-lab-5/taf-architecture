package main.businessobjects;

import main.constants.Constants;
import main.driver.Driver;
import main.domparser.xmlmodels.MessageData;
import main.pages.LetterWindowPage;

public class LetterWindowBusinessObject {
    private LetterWindowPage letterWindowPage;

    public void composeLetter(MessageData data, String subject) {
        letterWindowPage = new LetterWindowPage(Driver.getDriver());

        letterWindowPage.clickComposeButton();
        letterWindowPage.waitUntilUrlWillContains(Constants.COMPOSE);
        letterWindowPage.enterTo(data.getTo());
        letterWindowPage.enterCc(data.getCc());
        letterWindowPage.enterBcc(data.getBcc());
        letterWindowPage.enterSubject(subject);
        letterWindowPage.enterMessage(data.getMessage());
        letterWindowPage.closeAndSaveLetter();
    }

    public void sendLetter() {
        letterWindowPage.waitUntilUrlWillContains(Constants.COMPOSE);
        letterWindowPage.sendLetter();
    }

    public String getSubject() {
        return letterWindowPage.getSubjectFromInput();
    }
}
