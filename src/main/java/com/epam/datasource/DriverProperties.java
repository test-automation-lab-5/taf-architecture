package com.epam.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.datasource.Constants.*;

public class DriverProperties {

    private Properties prop = new Properties();

    public DriverProperties () {
       try (FileInputStream input = new FileInputStream(FILE_DRIVER)) {
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
