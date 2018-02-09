package main.pages.decorator.factory;

import main.pages.decorator.elements.AbstractElement;
import main.pages.decorator.elements.CustomElementFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    private CustomElementFactory elementFactory = new CustomElementFactory();

    CustomFieldDecorator(ElementLocatorFactory factory) {
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
        final WebElement wrapper = this.proxyForLocator(loader, this.factory.createLocator(field));
        return elementFactory.create((Class<? extends AbstractElement>) field.getType(), wrapper);
    }
}
