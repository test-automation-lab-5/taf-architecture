package com.epam.task2.businessobjects.pageobjects.decorator.elements.heandlers;

import com.epam.task2.businessobjects.pageobjects.decorator.elements.AbstractElement;
import com.epam.task2.businessobjects.pageobjects.decorator.elements.MyElementFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.List;

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
        if (List.class.isAssignableFrom(field.getType())) {
            return decorateElements(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = this.proxyForLocator(loader, this.factory.createLocator(field));
        return elementFactory.create((Class<? extends AbstractElement>) field.getType(), wrappedElement);
    }

    private Object decorateElements(final ClassLoader loader, final Field field) {
        return this.proxyMyForListLocator(loader, this.factory.createLocator(field), (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
    }

    protected <T extends AbstractElement> List<T> proxyMyForListLocator(ClassLoader loader, ElementLocator locator, Class type) {
        InvocationHandler handler = new MyElementsListHendler(locator, type);
        List<T> proxy = (List) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
        return proxy;
    }
}