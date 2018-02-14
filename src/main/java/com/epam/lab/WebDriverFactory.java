package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.epam.lab.ReadProperties.readDataFile;
import static com.epam.lab.ReadProperties.readPropertiesFile;

public class WebDriverFactory {
    private static final String CHROME = "chrome";




    private WebDriverFactory() { }
   /* private static WebDriverFactory instance = new WebDriverFactory();

    public static WebDriverFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            ReadProperties data = new ReadProperties();
            readPropertiesFile(data);
                System.setProperty( data.getChromeDriver(), data.getChromePath() );
                webDriver = new ChromeDriver();
                setWait( webDriver );
            return webDriver;
        }
    };

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    public void removeDriver() // Quits the driver and closes the browser
    {
        driver.get().quit();
        driver.remove();
    }





private static void setWait(WebDriver webDriver) {
    webDriver.manage().timeouts().implicitlyWait( 45, TimeUnit.SECONDS );
}
*/
   private static void setWait(WebDriver webDriver) {
       webDriver.manage().timeouts().implicitlyWait( 45, TimeUnit.SECONDS );
   }
    public static WebDriver getInstance() {
       WebDriver webDriver;
        ReadProperties data = new ReadProperties();
        readPropertiesFile(data);
            System.setProperty( data.getChromeDriver(), data.getChromePath() );
            webDriver = new ChromeDriver();
            setWait( webDriver );
        return webDriver;
    }




}

