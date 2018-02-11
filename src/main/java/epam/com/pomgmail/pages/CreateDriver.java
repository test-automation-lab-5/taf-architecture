package epam.com.pomgmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CreateDriver {

    private static final Integer IMPLICITLY_WAIT_TIME = 25;

    private CreateDriver(){

    }

    private static CreateDriver instance = new CreateDriver();

    public static CreateDriver getInstance()
    {
        return instance;
    }

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue()
        {
            return new ChromeDriver();
        }
    };

    public WebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver.get().manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
        return driver.get();
    }

    public void quitDriver()
    {
        try{
            driver.get().quit();
            driver.remove();
        }
        finally {

        }
    }
}
