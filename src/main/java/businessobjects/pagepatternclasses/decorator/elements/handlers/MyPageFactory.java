package businessobjects.pagepatternclasses.decorator.elements.handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class MyPageFactory extends PageFactory {
    public static void initElements(WebDriver driver, Object page) {
        initElements((new DefaultElementLocatorFactory(driver)), page);
    }

    public static void initElements(ElementLocatorFactory factory, Object page) {
        initElements((new MyFieldDecorator(factory)), page);
    }
}