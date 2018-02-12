package epam.com.pomgmail.pomdecorator;

import epam.com.pomgmail.pomdecorator.AbstractElement;
import org.openqa.selenium.WebElement;;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    private DefaultElementFactory elementFactory = new DefaultElementFactory();

    public CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (AbstractElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, this.factory.createLocator(field));
        return elementFactory.create((Class<? extends AbstractElement>) field.getType(), wrappedElement);
    }
}
