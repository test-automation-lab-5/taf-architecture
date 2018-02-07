package com.epam.lab;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(propOrder = {"mail", "password", "myProperty"})

public class MyProperty {

    String mail;
    String password;
    List<MyProperty> myProperty;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @XmlElement(name = "myProperty")
    public List<MyProperty> getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(List<MyProperty> myProperty) {
        this.myProperty = myProperty;
    }


}
