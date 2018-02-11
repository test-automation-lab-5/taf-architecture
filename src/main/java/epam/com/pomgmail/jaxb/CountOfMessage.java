package epam.com.pomgmail.jaxb;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="data")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountOfMessage {
    @XmlElement(name="count")
    private int count;

    public int getCount() {
        return count;
    }
}
