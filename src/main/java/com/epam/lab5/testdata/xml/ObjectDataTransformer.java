package com.epam.lab5.testdata.xml;

import com.epam.lab5.testdata.xml.entities.User;

import java.util.List;

import static com.epam.lab5.consts.Numbers.LOGIN_DATA_MATRIX_COLUMN_SIZE;

public class ObjectDataTransformer {

    public static Object[][] getListObjectsData() {
        List<User> userList = LoginDataReader.getUserList();
        Object[][] userObjects = new Object[userList.size()][LOGIN_DATA_MATRIX_COLUMN_SIZE];
            for (int i = 0; i < userList.size(); i++) {
                userObjects[i][0] = userList.get(i).getEmail();
                userObjects[i][1] = userList.get(i).getPassword();
            }
        return userObjects;
    }
}