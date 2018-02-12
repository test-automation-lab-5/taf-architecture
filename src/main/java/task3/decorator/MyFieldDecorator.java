package task3.decorator;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import task3.pageElements.Button;
import task3.pageElements.Input;
import task3.pageElements.PageElements;

import java.lang.reflect.Field;

public class MyFieldDecorator extends DefaultFieldDecorator {
    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        if (Button.class.isAssignableFrom(field.getType())) {
            return new Button(proxyForLocator(loader, locator));
        }
        else if (Input.class.isAssignableFrom(field.getType())) {
            return new Input(proxyForLocator(loader, locator));
        }
        else if (PageElements.class.isAssignableFrom(field.getType())) {
            return new PageElements(proxyForLocator(loader, locator));
        }
        else {
            return super.decorate(loader, field);
        }
    }
}

