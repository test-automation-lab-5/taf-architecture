package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.WebDriverProp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverObject {

    private static WebDriver driver;

    private DriverObject() {}

    public static void createDriver(){
        WebDriverProp webDriverProp = null;
        try {
            webDriverProp = new WebDriverProp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(webDriverProp.chromeDriver(), webDriverProp.readUrl());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
