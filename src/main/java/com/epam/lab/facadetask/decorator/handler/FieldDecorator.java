package com.epam.lab.facadetask.decorator.handler;

import java.lang.reflect.Field;

import com.epam.lab.facadetask.decorator.bo.elements.AbstractElement;
import com.epam.lab.facadetask.decorator.bo.elements.ElementFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class FieldDecorator extends DefaultFieldDecorator {
    private ElementFactory elementFactory = new ElementFactory();

   public FieldDecorator(ElementLocatorFactory elementLocatorFactory) {
        super(elementLocatorFactory);
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