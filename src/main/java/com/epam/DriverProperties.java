package com.epam;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverProperties {
    private Properties prop = new Properties();

    public DriverProperties () {
       try (FileInputStream input = new FileInputStream("src/main/resources/driver.properties");) {
           prop.load(input);
       } catch (IOException ex){
           ex.printStackTrace();
       }
    }

    public String getChromeDriver() {
        return prop.getProperty("webDriverChrome");
    }

    public String getUrl() {
        return prop.getProperty("pathDriver");
    }
}
