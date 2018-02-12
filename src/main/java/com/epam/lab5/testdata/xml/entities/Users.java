package com.epam.lab5.testdata.xml.entities;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name="user", type =User.class)
    private List<User> userList;

    public Users() {
        userList = new ArrayList<User>();
    }

    public List<User> getUserList() {
        return userList;
    }
    public void setUserList(List<User> user) {
        this.userList = user;
    }

}
