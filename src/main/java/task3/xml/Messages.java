package task3.xml;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class Messages {

    private List<Message> message;
    public Messages() {}
    public Messages(List<Message> message) {
        super();
        this.message = message;
    }
    @XmlElement
    public List<Message> getMessage() {
        return message;
    }
    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
