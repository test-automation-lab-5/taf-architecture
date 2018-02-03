package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebDriverProp {
    private final static String PROPERTY_PATH = "src\\\\main\\\\resources\\\\webDriver.properties";
    private Properties properties = new Properties();
    private FileInputStream fileInputStream = new FileInputStream(PROPERTY_PATH);

    public WebDriverProp() throws IOException {
        properties.load(fileInputStream);
    }

    public String chromeDriver() throws IOException {
        String chromeDriver = properties.getProperty("WebDriver");
        return chromeDriver;
    }

    public String readUrl() throws IOException {
        String chromeDriverPath = properties.getProperty("Path");
        return chromeDriverPath;
    }
}
