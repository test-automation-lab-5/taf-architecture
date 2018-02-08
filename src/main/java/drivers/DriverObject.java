package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.WebDriverProp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverObject {

    private static WebDriver driver;
    private static Map<String, WebDriver> driverMap = new HashMap<>();
    private DriverObject() {}


    private static WebDriver createDriver(){
        WebDriverProp webDriverProp = null;
        try {
            webDriverProp = new WebDriverProp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(webDriverProp.chromeDriver(), webDriverProp.readUrl());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    public static WebDriver driverQuit(){
        String currentThread = Thread.currentThread().getName();
        WebDriver driver = driverMap.get(currentThread);
        if (driver != null){
            driver.quit();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        String currentThread = Thread.currentThread().getName();
        WebDriver driver = driverMap.get(currentThread);
        if (driver == null) {
            driver = createDriver();
            System.out.println(Thread.currentThread().getName());
            driverMap.put(currentThread, driver);
        }
        return driver;
    }
}
