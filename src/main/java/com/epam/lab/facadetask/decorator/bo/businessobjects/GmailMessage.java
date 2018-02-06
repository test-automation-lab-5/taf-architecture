package com.epam.lab.facadetask.decorator.bo.businessobjects;
import com.epam.lab.facadetask.decorator.bo.pages.GmailPage;

public class GmailMessage {

    private GmailPage gmailPage;

    public GmailMessage(){
    this.gmailPage = new GmailPage();

    }
    public void sendMessage(String receiver, String subject, String message){
        gmailPage.sendMessage(receiver, subject, message);
        gmailPage.goToSentFolder();

    }

    public boolean isComposePresent(){
        return (gmailPage.getComposeCheck()!=null);
    }

    public void removeMessage(){
        gmailPage.removeLetter();
    }

    public boolean isRemoved() {
        return gmailPage.getMovedToTrashMessage().equals("The conversation has been moved to the Trash.");
    }


}

