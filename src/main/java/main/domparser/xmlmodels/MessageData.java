package main.domparser.xmlmodels;

import java.util.Random;

public class MessageData {
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String message;

    public MessageData(String to, String cc, String bcc, String subject, String message) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.message = message;
    }

    public MessageData() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String generateSubject() {
        String subject = "";
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            subject += (char) (random.nextInt(75) + 48);
        }

        return subject;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "to='" + to + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
