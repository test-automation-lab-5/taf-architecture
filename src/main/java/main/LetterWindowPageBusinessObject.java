package main;

import main.pages.LetterWindowPage;
import properties.DataProp;

public class LetterWindowPageBusinessObject {
    private LetterWindowPage letterWindowPage;
    private static String subject;

    public void composeLetter(DataProp dataProp) {
        letterWindowPage = new LetterWindowPage(Driver.getInstance());
        subject = dataProp.generateSubject();

        letterWindowPage.clickComposeButton();
        letterWindowPage.waitUntilBeClickable(5);
        letterWindowPage.enterTo(dataProp.getMailTo());
        letterWindowPage.enterCc(dataProp.getMailCc());
        letterWindowPage.enterBcc(dataProp.getMailBcc());
        letterWindowPage.enterSubject(subject);
        letterWindowPage.enterMessage(dataProp.generateMessage());
        letterWindowPage.closeAndSaveLetter();
    }

    public void sendLetter() {
        letterWindowPage.sendLetter();
    }

    public boolean isTheSame(){
        return subject.equals(letterWindowPage.getSubjectFromInput());
    }

    public static String getSubject(){
        return subject;
    }
}
