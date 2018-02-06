package com.epam.task4.testdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userData")
public class UserData {
    @XmlElement(name = "userMail")
    private String userMail;
    @XmlElement(name = "userPassword")
    private String userPassword;


    UserData() {
        userMail = null;
        userPassword = null;
    }

    UserData(String userMail, String userPassword) {
        this.userMail = userMail;
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
