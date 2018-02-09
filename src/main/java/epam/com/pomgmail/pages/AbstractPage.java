package epam.com.pomgmail.pages;

import epam.com.pomgmail.pomdecorator.CustomFieldDecorator;
import epam.com.pomgmail.pomdecorator.InitElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class AbstractPage {
    WebDriver driver;

    AbstractPage(){
        driver = InstancePage.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    AbstractPage(InitElements initElements){
        driver = InstancePage.getInstance().getDriver();
        initElements.initElements(driver, this);
    }

}
