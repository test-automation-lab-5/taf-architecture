package com.epam.task4.testdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "usersData")
public class UsersData {
    @XmlElement(name = "userData")
    private List<UserData> usersDataList;

    public UsersData() {
        usersDataList = new ArrayList<>();
    }

    public Object[][] toObjects() {
        Object[][] res = new Object[usersDataList.size()][2];
        for (int i = 0; i < usersDataList.size(); i++) {
            res[i][0] = usersDataList.get(i).getUserMail();
            res[i][1] = usersDataList.get(i).getUserPassword();
        }
        return res;
    }
}
