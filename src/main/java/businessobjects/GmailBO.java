package businessobjects;


import pagepatternclasses.GmailPage;
import pagepatternclasses.LoginPage;

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
        gmailPage.getSentPage();
    }

    public String getSubject() {
        return gmailPage.getSubject();
    }

    public void muveLetter() {
        gmailPage.removeLetterFromSend();
        gmailPage.pushDeleteOkButton();
    }

    public String getMuvedMessage() {
        return gmailPage.getMovedMessage();
    }
}
