package testdata.xmlmodels;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LetterData {
    private String sentTo;
    private String subject;
    private String message;

    public String getSentTo() {
        return sentTo;
    }
    @XmlElement
    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public  String getSubject() {
        return subject;
    }
    @XmlElement
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }
    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }
}
