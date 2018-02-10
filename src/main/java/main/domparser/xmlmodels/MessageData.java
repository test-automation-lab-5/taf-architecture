package main.domparser.xmlmodels;

import java.util.Random;

public class MessageData {
    private String to;
    private String cc;
    private String bcc;
    private String message;

    private MessageData(Builder builder) {
        this.to = builder.to;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.message = builder.message;
    }

    public String getTo() {
        return to;
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    public String getMessage() {
        return message;
    }

    public String generateSubject() {
        String subject = "";
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            subject += (char) (random.nextInt(75) + 48);
        }

        return subject;
    }

    public static class Builder {
        private String to;
        private String cc;
        private String bcc;
        private String message;

        public Builder setTo(String to) {
            this.to = to;
            return this;
        }

        public Builder setCc(String cc) {
            this.cc = cc;
            return this;
        }

        public Builder setBcc(String bcc) {
            this.bcc = bcc;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public MessageData build() {
            return new MessageData(this);
        }
    }
}
