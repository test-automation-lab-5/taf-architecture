package edu.epam.seleniumexample.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyContainer {

    private static final String PATH_TO_PROPERTIES = "src/test/resources/tests.properties";

   private String driverType;
   private String driverPath;
   private String startPage;
   private String usersListFile;

    public void loadProperties() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            driverType = properties.getProperty("driverType");
            driverPath = properties.getProperty("driverPath");
            startPage = properties.getProperty("startPage");
            usersListFile = properties.getProperty("usersListFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getUsersListFile() {
        return usersListFile;
    }

    public void setUsersListFile(String usersListFile) {
        this.usersListFile = usersListFile;
    }
}
