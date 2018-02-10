package properties;

import main.constants.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class DataProp {
    private Properties properties = new Properties();

    public DataProp() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/data.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String driver() {
        return properties.getProperty(Constants.DRIVER);
    }

    public String driverPath() {
        return properties.getProperty(Constants.DRIVER_PATH);
    }

    public String getURL() {
        return properties.getProperty(Constants.URL);
    }
}
