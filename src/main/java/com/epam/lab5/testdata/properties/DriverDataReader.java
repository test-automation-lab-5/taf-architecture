package com.epam.lab5.testdata.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.lab5.consts.Paths.DRIVER_PROP_FILE_PATH;

public class DriverDataReader {

   static Properties  properties = new Properties();

    public DriverDataReader() throws IOException {
        FileInputStream inputStream = new FileInputStream(DRIVER_PROP_FILE_PATH);
        properties.load(inputStream);
        inputStream.close();
    }

    public String getChromeDriver(){
        return properties.getProperty("driver.chrome");
    }

    public  String getDriverPath(){
        return properties.getProperty("driver.path");
    }

    public static String getMailLink() {
        return properties.getProperty("driver.link");
    }
}
