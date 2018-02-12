package task3.xml;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    private String receiver;
    private String subject;
    private String content;

    Message() { }
    public Message(String receiver, String subject, String content) {
        super();
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
    }
    public String getReceiver() {
        return receiver;
    }
    @XmlElement
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getSubject() {
        return subject;
    }
    @XmlElement
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    @XmlElement
    public void setContent(String message) {
        this.content = message;
    }

}