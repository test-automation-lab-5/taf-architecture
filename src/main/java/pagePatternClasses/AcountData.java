package pagePatternClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AcountData {
    private final static String PROPERTY_PATH = "src\\\\main\\\\resources\\\\gmailAcount.properties";
    private Properties properties = new Properties();
    private FileInputStream fileInputStream = new FileInputStream(PROPERTY_PATH);

    public AcountData() throws FileNotFoundException {
    }

    public String getGmaiUrl() throws IOException {
        properties.load(fileInputStream);
        String gmailUrl = properties.getProperty("URL");
        return gmailUrl;
    }

    public String getUserName() throws IOException {
        properties.load(fileInputStream);
        String userName = properties.getProperty("USER_NAME");
        return userName;
    }

    public String getUserPassword() throws IOException {
        properties.load(fileInputStream);
        String userPassword = properties.getProperty("PASSWORD");
        return userPassword;
    }
}
