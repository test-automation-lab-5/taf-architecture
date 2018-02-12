package task3.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class Users {

    private List<User> user;
    public Users() {}
    public Users(List<User> user) {
        super();
        this.user = user;
    }
    @XmlElement
    List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }
}