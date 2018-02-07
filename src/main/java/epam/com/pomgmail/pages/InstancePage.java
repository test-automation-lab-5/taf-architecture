package epam.com.pomgmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InstancePage {
//
//    private static WebDriver driver;
//
//    private static Map<Long, WebDriver> driverMap = new HashMap<>();

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

//    public static WebDriver openBrowser(){
//        driver = new ChromeDriver();
//        return driver;
//    }
//
//    public static WebDriver getInstance(){
//        long currentThreadId = Thread.currentThread().getId();
//        WebDriver driver = driverMap.get(currentThreadId);
//        if(driver == null){
//            driver = openBrowser();
//            driverMap.put(currentThreadId, driver);
//        }
//        return driverMap.get(currentThreadId);
//        long currentThreadId = Thread.currentThread().getId();
//        if(Objects.isNull(driverMap.get(currentThreadId)))
//            driverMap.put(currentThreadId, new ChromeDriver());
//        return driverMap.get(currentThreadId);
//    }
}
