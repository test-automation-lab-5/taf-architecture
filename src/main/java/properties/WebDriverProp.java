package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebDriverProp {
    private final static String PROPERTY_PATH = "src\\\\main\\\\resources\\\\webDriver.properties";
    private static Properties properties;
    private FileInputStream fileInputStream;

    public WebDriverProp() throws IOException {

        properties = new Properties();
        fileInputStream = new FileInputStream(PROPERTY_PATH);
        properties.load(fileInputStream);
    }

    public String chromeDriver() {
        String chromeDriver = properties.getProperty("webdriver");
        return chromeDriver;
    }

    public String readPath(){
        String chromeDriverPath = properties.getProperty("path");
        return chromeDriverPath;
    }
    public static String readUrl(){
        return properties.getProperty("url");
    }

}
