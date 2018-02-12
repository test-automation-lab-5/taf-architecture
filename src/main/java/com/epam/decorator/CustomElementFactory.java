package com.epam.decorator;

import org.openqa.selenium.WebElement;
import java.lang.reflect.InvocationTargetException;



public class CustomElementFactory {

    public <E extends AbstractElement> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return elementClass.getDeclaredConstructor(WebElement.class).newInstance(wrappedElement);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

}
