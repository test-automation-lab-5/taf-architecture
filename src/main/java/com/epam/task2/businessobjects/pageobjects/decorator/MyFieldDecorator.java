package com.epam.task2.businessobjects.pageobjects.decorator;

import com.epam.task2.businessobjects.pageobjects.decorator.elements.AbstractElement;
import com.epam.task2.businessobjects.pageobjects.decorator.elements.MyElementFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.*;
import java.util.List;

public class MyFieldDecorator extends DefaultFieldDecorator {
    private MyElementFactory elementFactory = new MyElementFactory();

    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!AbstractElement.class.isAssignableFrom(field.getType()) && !this.isDecoratableList(field)) {
            return null;
        } else {
            ElementLocator locator = this.factory.createLocator(field);
            if (locator == null) {
                return null;
            } else if (AbstractElement.class.isAssignableFrom(field.getType())) {
                return elementFactory.create((Class<? extends AbstractElement>) field.getType(), this.proxyForLocator(loader, locator));
            } else {
                return List.class.isAssignableFrom(field.getType()) ? this.proxyForListLocator(loader, locator) : null;
            }
        }
    }

    @Override
    protected boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        } else {
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return false;
            } else {
                Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                if (!AbstractElement.class.equals(listType)) {
                    return false;
                } else {
                    return field.getAnnotation(FindBy.class) != null || field.getAnnotation(FindBys.class) != null || field.getAnnotation(FindAll.class) != null;
                }
            }
        }
    }

    @Override
    protected WebElement proxyForLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementHandler(locator);
        WebElement proxy = (WebElement) Proxy.newProxyInstance(loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class}, handler);
        return proxy;
    }

    @Override
    protected List<WebElement> proxyForListLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementListHandler(locator);
        List<WebElement> proxy = (List) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
        return proxy;
    }
}
