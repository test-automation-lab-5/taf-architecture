package com.epam.datasource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersData implements Serializable {
    @XmlElement(name = "user", type = User.class)
    private List<User> usersData = null;

    public UsersData() {
    }

    public UsersData(List<User> usersData) {
        this.usersData = usersData;
    }


    public List<User> getUsersData() {
        return usersData;
    }

    public void setUsersData(List<User> usersData) {
        this.usersData = usersData;
    }
}
