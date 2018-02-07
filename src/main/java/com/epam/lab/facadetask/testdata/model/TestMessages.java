package com.epam.lab.facadetask.testdata.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "testMessages")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestMessages implements Serializable {
    @XmlElement(name = "testMessage", type = TestMessage.class)
    private List<TestMessage> testMessages;

    public TestMessages(){}

    public TestMessages(List<TestMessage> testMessages){ this.testMessages = testMessages; }

    public void setTestMessages(List<TestMessage> testMessages) {
        this.testMessages = testMessages;
    }

    public List<TestMessage> getTestMessages() {
        return testMessages;
    }
}
