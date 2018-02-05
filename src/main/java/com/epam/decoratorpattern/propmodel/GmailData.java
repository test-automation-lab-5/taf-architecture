package com.epam.decoratorpattern.propmodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GmailData {
    private Properties prop = new Properties();

    public GmailData() {
        FileInputStream input = null;
		try {
			input = new FileInputStream("src/main/resources/gmailData.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public String getGmailLink() {
        return prop.getProperty("mailLink");
    }

    public String getUserLogin() {
        return prop.getProperty("mail");
    }

    public String getUserPassword() {
        return prop.getProperty("mailPassword");
    }

    public String getMessageSentTo() {
        return prop.getProperty("mailTo");
    }

    public String getMessageSubject() {
        return prop.getProperty("mailSubject");
    }

    public String getMessageText() {
        return prop.getProperty("mailMessage");
    }
}
