package main.businessobjects;

import main.Driver;
import main.domparser.xmlmodels.MessageData;
import main.pages.LetterWindowPage;

public class LetterWindowPageBusinessObject {
    private LetterWindowPage letterWindowPage;

    public void composeLetter(MessageData data, String subject) {
        letterWindowPage = new LetterWindowPage(Driver.getDriver());

        letterWindowPage.clickComposeButton();
        letterWindowPage.waitUntilUrlContains();
        letterWindowPage.enterTo(data.getTo());
        letterWindowPage.enterCc(data.getCc());
        letterWindowPage.enterBcc(data.getBcc());
        letterWindowPage.enterSubject(subject);
        letterWindowPage.enterMessage(data.getMessage());
        letterWindowPage.closeAndSaveLetter();
    }

    public void sendLetter() {
        letterWindowPage.sendLetter();
    }

    public String getSubject() {
        return letterWindowPage.getSubjectFromInput();
    }
}
