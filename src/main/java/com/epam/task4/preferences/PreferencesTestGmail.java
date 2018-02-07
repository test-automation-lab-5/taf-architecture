package com.epam.task4.preferences;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PreferencesTestGmail extends PreferencesLoader {
    private static final Logger log = Logger.getLogger(PreferencesTestGmail.class);

    private String driverType = null;
    private String driverURL = null;
    private Integer implicitlyWait = null;
    private Integer timeOutInSeconds = null;
    private Integer sleepInMillis = null;
    private Integer threadsLimit = null;

    @Override
    public void loadPreferences(String preferencesFileURL) throws IOException, PreferencesLoadException {
        log.info("Load TestGmail preferences");
        try {
            prop = new Properties();
            prop.load(PreferencesTestGmail.class.getResourceAsStream(preferencesFileURL));
            driverType = loadProperty("driverType");
            driverURL = loadProperty("driverURL");
            implicitlyWait = Integer.parseInt(loadProperty("implicitlyWait"));
            timeOutInSeconds = Integer.parseInt(loadProperty("timeOutInSeconds"));
            sleepInMillis = Integer.parseInt(loadProperty("sleepInMillis"));
            threadsLimit = Integer.parseInt(loadProperty("threadsLimit"));
        } catch (IOException | PreferencesLoadException exception) {
            log.error(exception.getMessage());
            throw exception;
        }
        log.info("TestGmail preferences loaded");
    }

    public String getDriverType() {
        return driverType;
    }

    public String getDriverURL() {
        return driverURL;
    }

    public Integer getImplicitlyWait() {
        return implicitlyWait;
    }

    public Integer getTimeOutInSeconds() {
        return timeOutInSeconds;
    }

    public Integer getSleepInMillis() {
        return sleepInMillis;
    }

    public Integer getThreadsLimit() {
        return threadsLimit;
    }
}