package com.epam.lab;

import com.epam.lab.xmlModel.LoginDataProp;
import com.epam.lab.xmlModel.XmlToObject;
import org.testng.annotations.DataProvider;

import java.util.List;

public class ParallelTestData {
    @DataProvider(name = "testData", parallel = true)
    public Object[][] testData() {
        List<LoginDataProp> list = XmlToObject.getData();

        return new Object[][]{

                {list.get(0).getLoginData(), list.get(0).getPasswordData()},
                {list.get(1).getLoginData(), list.get(1).getPasswordData()},
                {list.get(2).getLoginData(), list.get(2).getPasswordData()},
                {list.get(3).getLoginData(), list.get(3).getPasswordData()},
                {list.get(4).getLoginData(), list.get(4).getPasswordData()},
        };
    }
}
