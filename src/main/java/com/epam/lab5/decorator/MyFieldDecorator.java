package com.epam.lab5.decorator;

import com.epam.lab5.decorator.elements.PageElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class MyFieldDecorator extends DefaultFieldDecorator {

    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {

        ElementLocator locator = factory.createLocator(field);

        if (PageElement.class.isAssignableFrom(field.getType())) {
            final PageElement pageElement = new PageElement(proxyForLocator(loader, locator));
            return pageElement;
        }
        else {
            return super.decorate(loader, field);
        }

    }

}