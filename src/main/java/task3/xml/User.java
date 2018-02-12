package task3.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class User {
    private String email;
    private String password;
    User() { }
    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    @XmlElement
    void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    @XmlElement
    void setPassword(String password) {
        this.password = password;

    }
}