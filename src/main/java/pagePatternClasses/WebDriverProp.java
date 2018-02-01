package pagePatternClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebDriverProp {
    private final static String PROPERTY_PATH = "src\\\\main\\\\resources\\\\webDriver.properties";
    private Properties properties = new Properties();
    private FileInputStream fileInputStream = new FileInputStream(PROPERTY_PATH);

    public WebDriverProp() throws FileNotFoundException {
    }

    public String chromeDriver() throws IOException {
        properties.load(fileInputStream);
        String chromeDriwer = properties.getProperty("WebDriver");
        return chromeDriwer;
    }

    public String readUrl() throws IOException {
        properties.load(fileInputStream);
        String chromeDriwerPath = properties.getProperty("Path");
        return chromeDriwerPath;
    }
}
