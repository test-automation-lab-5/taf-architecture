package com.epam.fivethreads.driverfactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.fivethreads.propmodel.WebDriverData;

import java.util.HashMap;
import java.util.Map;

public class DriverManagerFactory {
    private static final Logger LOG = Logger.getLogger(DriverManagerFactory.class);
      private static DriverManager driverManager;


    private DriverManagerFactory() {

    }

    private static DriverManager getManager() {
        WebDriverData webDriverData = new WebDriverData();
        String drType = webDriverData.getType();
        if (null == driverManager) {
            if (drType.equals(DriverType.CHROME.toString())) {
                driverManager = new ChromeDriverManager();
            } else if (drType.equals(DriverType.FIREFOX.toString())) {
                driverManager = new FirefoxDriverManager();
            }
            ;
        }
        return driverManager;
    }

    public static WebDriver getDriver() {

        return getManager().getDriver();

    }
}
