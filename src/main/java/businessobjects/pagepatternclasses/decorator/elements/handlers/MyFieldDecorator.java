package businessobjects.pagepatternclasses.decorator.elements.handlers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import businessobjects.pagepatternclasses.decorator.elements.elements.AbstractElement;
import businessobjects.pagepatternclasses.decorator.elements.elements.MyElementFactory;

import java.lang.reflect.Field;

public class MyFieldDecorator extends DefaultFieldDecorator {
    private MyElementFactory elementFactory = new MyElementFactory();

    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (AbstractElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = this.proxyForLocator(loader, this.factory.createLocator(field));
        return elementFactory.create((Class<? extends AbstractElement>) field.getType(), wrappedElement);
    }

}
