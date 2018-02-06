package com.epam.lab.facadetask.bo;

import com.epam.lab.facadetask.model.TestMessage;
import com.epam.lab.facadetask.pages.GmailPage;
import com.epam.lab.facadetask.testdata.marshall.UnMarshell;

import java.io.IOException;

public class GmailMessage {

    private GmailPage gmailPage = new GmailPage();

    public GmailMessage() throws IOException {
    }
    public void sendMessage(){

        TestMessage message = UnMarshell.unmarshaller();

        if (message != null) {
            gmailPage.sendMessage(message.getReceiver(), message.getSubject(), message.getMessage());
        }
    }

    public boolean isComposePresent(){
        return (gmailPage.getComposeCheck()!=null);
    }

    public void goToSentFolder(){
        gmailPage.goToSentFolder();
    }

    public void removeMessage(){
        gmailPage.removeLetter();
    }

    public boolean isRemoved() {
        return gmailPage.getMovedToTrashMessage().equals("The conversation has been moved to the Trash.");
    }


}

