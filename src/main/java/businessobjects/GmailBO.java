package businessobjects;


import businessobjects.pagepatternclasses.GmailPage;
import businessobjects.pagepatternclasses.LoginPage;

public class GmailBO {
    private LoginPage loginPage;
    private GmailPage gmailPage;

    public GmailBO() {
        this.loginPage = new LoginPage();
        this.gmailPage = new GmailPage();
    }

    public void login(String login, String password) {
        loginPage.loginGmail(login);
        loginPage.setPasswordInput(password);
        loginPage.openGmailPage();
    }

    public void sendMail(String sentTo, String subject, String message) {
        gmailPage.sendLetter(sentTo, subject, message);
    }
    public void getSentPage(){
        System.out.println("getSent");
        gmailPage.getSentPage();
    }

    public String getSubject(String subject) {
        return gmailPage.getSubject(subject);
    }

    public void moveLetter() {
        gmailPage.removeLetterFromSend();
        gmailPage.pushDeleteOkButton();
    }

    public String getMovedMessage() {
        return gmailPage.getMovedMessage();
    }
}
