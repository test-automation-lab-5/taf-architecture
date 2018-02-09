package com.epam.lab;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyProperties {
    MyProperty myProperty;

    @XmlElement(name = "myProperty")
    public MyProperty getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(MyProperty myProperty) {
        this.myProperty = myProperty;
    }

}
