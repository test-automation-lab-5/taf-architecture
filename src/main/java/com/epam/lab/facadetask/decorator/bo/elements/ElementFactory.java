package com.epam.lab.facadetask.decorator.bo.elements;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;


public class ElementFactory {

    public <T extends AbstractElement> T create(Class<T> elementClass, WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <E extends AbstractElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(getClass().getPackage().getName() + "." + elementClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}