package epam.com.pomgmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InstancePage {

    private InstancePage(){

    }

    private static InstancePage instance = new InstancePage();

    public static InstancePage getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue()
        {
            return new ChromeDriver();
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver()
    {
        driver.get().quit();
        driver.remove();
    }
}
