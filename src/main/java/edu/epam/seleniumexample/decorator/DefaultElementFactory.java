package edu.epam.seleniumexample.decorator;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class DefaultElementFactory {

    public <E extends AbstractElement> E create(final Class<E> elementClass, final WebElement wrappedElement) {
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
            return (Class<? extends E>) Class.forName(String.format("%s.%s", getClass().getPackage().getName(),
                    elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
