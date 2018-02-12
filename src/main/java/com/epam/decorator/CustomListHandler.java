package com.epam.decorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CustomListHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final Class type;
    private final CustomElementFactory customElementFactory;

    CustomListHandler(ElementLocator locator, Class type) {
        this.locator = locator;
        this.type = type;
        this.customElementFactory = new CustomElementFactory();
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<AbstractElement> elements = new ArrayList<>();
        for (WebElement element : locator.findElements())
            elements.add(customElementFactory.create(type, element));
        try {
            return method.invoke(elements, objects);
        } catch (InvocationTargetException ex) {
            throw ex.getCause();
        }
    }
}


