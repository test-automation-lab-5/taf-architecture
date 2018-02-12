package com.epam.lab5.testdata.xml.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mailComponent")
public class MailComponent {

    @XmlElement(name = "subjectfield")
    private String subjectField;
    @XmlElement(name = "messagefield")
    private String messageField;

    public MailComponent(){}

    public MailComponent(String subjectField, String messageField) {
        this.subjectField = subjectField;
        this.messageField = messageField;
    }

    public String getSubjectField() {
        return subjectField;
    }

    public String getMessageField() {
        return messageField;
    }


}
