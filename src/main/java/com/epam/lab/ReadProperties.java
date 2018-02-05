package com.epam.lab;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private Properties prop = null;

    private void readPropertiesFile(String propertyFileName) {
        prop = new Properties();
        try {
            InputStream input = new FileInputStream( propertyFileName );
            prop.load( input );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDataFile(ReadProperties data) {
        data.readPropertiesFile( "dataFile.properties" );
    }

    static void readPropertiesFile(ReadProperties data) {
        data.readPropertiesFile( "prop.properties" );
    }


    public String getUrl() {
        return prop.getProperty( "url" );
    }

    String getBrowserName() {
        return prop.getProperty( "browser" );
    }

    public String getPassword() {
        return prop.getProperty( "password" );
    }

    public String getEmail() {
        return prop.getProperty( "email" );
    }

    String getChromeDriver() {
        return prop.getProperty( "chrome.driver" );
    }

    String getChromePath() {
        return prop.getProperty( "chrome.path" );
    }

    public String getUrlLoginPassed() {
        return prop.getProperty( "url.login.passed" );
    }
}

