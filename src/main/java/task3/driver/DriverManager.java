package task3.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import task3.constants.Constants;
import task3.properties.WebDriverData;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class DriverManager
{
    private static Semaphore semaphore = new Semaphore(Constants.PERMITS_THREAD);
    private DriverManager()
    {}
    private static DriverManager instance = new DriverManager();
    public static DriverManager getInstance()
    {
        return instance;
    }
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebDriverData webDriverData = new WebDriverData();
            System.setProperty(webDriverData.getDriver("driver"),webDriverData.getDriver("path"));
            return new ChromeDriver();
        }
    };
    public WebDriver getDriver()  {
        return driver.get();
    }
    public void closeDriver()
    {
        if (!Objects.isNull(driver.get()))
            driver.get().quit();
        driver.remove();
        semaphore.release();

    }
}
