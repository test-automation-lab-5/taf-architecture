package epam.com.pomgmail.jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name="user")
    private List<User> users = null;

    public List<User> getUsers() {
        return users;
    }

}
