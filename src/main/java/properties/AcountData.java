package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AcountData {
    private final static String PROPERTY_PATH = "src\\\\main\\\\resources\\\\gmailAcount.properties";
    private Properties properties = new Properties();
    private FileInputStream fileInputStream = new FileInputStream(PROPERTY_PATH);

    public AcountData() throws IOException {
        properties.load(fileInputStream);
    }

    public String getGmaiUrl() throws IOException {
        String gmailUrl = properties.getProperty("URL");
        return gmailUrl;
    }

    public String getUserName() throws IOException {
        String userName = properties.getProperty("USER_NAME");
        return userName;
    }

    public String getUserPassword() throws IOException {
        String userPassword = properties.getProperty("PASSWORD");
        return userPassword;
    }
}
