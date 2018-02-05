package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private Driver(){}
    private static final WebDriver driver = new ChromeDriver();
    public static WebDriver getInstance() {
        return driver;
    }
}
