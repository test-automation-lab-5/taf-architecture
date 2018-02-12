package task3.waiter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import task3.constants.Constants;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Waiter {
    public static void waitForElements(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIME_OUT_30, SECONDS);
    }
    public static void waitFor(WebDriver driver, final ExpectedCondition condition){
        (new WebDriverWait(driver, Constants.DEFAULT_TIME_OUT_10))
                .until(condition);
    }
    public static FluentWait waitfluent(WebDriver driver){
        return new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
    }

}