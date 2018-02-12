package com.epam.decorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.List;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    private CustomElementFactory customElementFactory = new CustomElementFactory();

    CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (AbstractElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        if (List.class.isAssignableFrom(field.getType())) {
            return decorateList(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = this.proxyForLocator(loader, this.factory.createLocator(field));
        return customElementFactory.create((Class<? extends AbstractElement>) field.getType(), wrappedElement);
    }

    private Object decorateList(final ClassLoader loader, final Field field) {
        return this.proxyForListLocator(loader, this.factory.createLocator(field), (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
    }

    private List proxyForListLocator(ClassLoader loader, ElementLocator locator, Class type) {
        InvocationHandler handler = new CustomListHandler(locator, type);
        return (List) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }

}
