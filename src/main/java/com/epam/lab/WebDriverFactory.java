package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.epam.lab.ReadProperties.readDataFile;
import static com.epam.lab.ReadProperties.readPropertiesFile;

public class WebDriverFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";



public static void setWait(WebDriver webDriver){
    webDriver.manage().timeouts().implicitlyWait( 45, TimeUnit.SECONDS );

}


    public static WebDriver getInstance() {
        WebDriver webDriver;
        ReadProperties data = new ReadProperties();
        readPropertiesFile(data);
        ReadProperties testData = new ReadProperties();
        readDataFile( testData );
        String browser = testData.getBrowserName();



        if (CHROME.equals( browser )) {
            System.setProperty( data.getChromeDriver(), data.getChromePath() );
            webDriver = new ChromeDriver();
            setWait( webDriver );
        } else if (FIREFOX.equals( browser )) {
            DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
            capabilitiesFirefox.setCapability("marionette", false);
            webDriver = new FirefoxDriver(capabilitiesFirefox);
            setWait( webDriver );
        } else throw new IllegalArgumentException( "Invalid browser property" );
        return webDriver;
    }
}

