package com.epam.lab5.testdata.xml.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
        private String email;
        private String password;

    public User() {
    }

    public User(String email, String password) {
            this.email = email;
            this.password = password;
        }
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;

        }

}

