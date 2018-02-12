package task3.properties;
import task3.constants.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class WebDriverData {
    private Properties properties = new Properties();
    public WebDriverData(){}
    public String getDriver(String driver)  {
        try {
            FileInputStream fileInputStream  = new FileInputStream(Constants.FILE_PATH_DRIVER_PROPERTIES);
            properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (driver) {
            case "driver":
                return properties.getProperty("webdriver.chrome.driver");
            case "path":
                return properties.getProperty("chromedriver.exe");
            case "url":
                return properties.getProperty("url.gmail");
        }
        return driver;
    }
}
