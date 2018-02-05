package com.epam.decoratorpattern.propmodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebDriverData {
    private Properties prop = new Properties();

    public WebDriverData() {
        FileInputStream input = null;
		try {
			input = new FileInputStream("src/main/resources/driver.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public String getType() {
        return prop.getProperty("typeDriver");
    }
    public String getDriver() {
        return prop.getProperty("webDriverChrome");
    }

    public String getUrl() {
        return prop.getProperty("pathDriverChrome");
    }
    
    
}
