package task3.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import task3.driver.DriverManager;
import task3.waiter.Waiter;
import task3.decorator.MyFieldDecorator;

abstract class AbstractPage {
    WebDriver driver = DriverManager.getInstance().getDriver();
    AbstractPage(){
        Waiter.waitForElements(driver);
        PageFactory.initElements(
                new MyFieldDecorator(
                        new DefaultElementLocatorFactory(driver)
                ), this);
    }

}