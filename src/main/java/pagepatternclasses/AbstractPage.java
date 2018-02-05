package pagepatternclasses;

import drivers.DriverObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    private WebDriver driver;

    AbstractPage() {
        this.driver = DriverObject.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, 25));
    }

    protected String getSubject(String subject) {
        return driver.findElement(By.xpath("//*[@class='bog']//*[text()='" + String.format("%s", subject) + "']")).getText();
    }

    protected WebElement waitUntilBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
}
