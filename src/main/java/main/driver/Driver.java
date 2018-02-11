package main.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.DataProp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static Map<Long, WebDriver> drivers = new HashMap<>();

    private Driver() {}

    private static WebDriver getInstance() {
        DataProp dataProp = new DataProp();
        System.setProperty(dataProp.driver(), dataProp.driverPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {
        return drivers.computeIfAbsent(Thread.currentThread().getId(), k -> Driver.getInstance());
    }

    public static void destroy() {
        drivers.remove(Thread.currentThread().getId()).quit();
    }
}
