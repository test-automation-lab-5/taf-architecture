package com.epam.fivethreads.pages;

import static com.epam.fivethreads.constant.Constant.ALERT_WAIT_TIME;

import com.epam.fivethreads.driver.SafeThreadDriverCreator;
import com.epam.fivethreads.decorator.elements.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.fivethreads.decorator.CustomFieldDecorator;


public abstract class AbstractPage {
    private static final Logger LOG = Logger.getLogger(AbstractPage.class);
    protected final WebDriver driver;

    public AbstractPage() {
        //this.driver  = DriverManager.getDriverThreadLocal();    //One Driver
        this.driver = SafeThreadDriverCreator.getInstance().getDriverThreadLocal();  //Multi-thread driver
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void openPage(String pageURL) {
        driver.get(pageURL);
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    protected void waitForElementToLoad(Element element) {
        int secondsCount = 0;
        boolean isElementShownIndicator = element.isDisplayed();;
        while (!isElementShownIndicator && secondsCount < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isElementShownIndicator = element.isDisplayed();
        }
        if (!isElementShownIndicator) {
            throw new AssertionError("Element was not shown");
        }
    }


    public boolean isAlertPresent() {
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, ALERT_WAIT_TIME);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {

        }
        return foundAlert;
    }
}
