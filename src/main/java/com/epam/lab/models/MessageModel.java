package com.epam.lab.models;

import com.epam.lab.models.unmarsheller.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "messages")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageModel {
    @XmlElement(name = "message")
    public List<Message> messages = null;

    public List<Message> getMessages() {
        return messages;
    }

    public void setUsers(List<Message> messages) {
        this.messages = messages;
    }
}
