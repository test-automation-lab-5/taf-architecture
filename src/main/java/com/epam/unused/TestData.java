package com.epam.unused;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestData {



    private String login;
    private String password;
    private String address;
    private String subject;
    private String body;

    public String getLogin() {
        return login;
    }

    @XmlAttribute
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    @XmlAttribute
    public void setPassword(String password) {
        this.password = password;
    }



    public String getAddress() {
        return address;
    }

    @XmlAttribute
    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    @XmlAttribute
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    @XmlAttribute
    public void setBody(String body) {
        this.body = body;
    }

}
