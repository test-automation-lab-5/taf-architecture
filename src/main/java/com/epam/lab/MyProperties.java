package com.epam.lab;

import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

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
