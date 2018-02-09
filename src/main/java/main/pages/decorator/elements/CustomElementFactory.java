package main.pages.decorator.elements;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class CustomElementFactory {
    public <E extends AbstractElement> E create(final Class<E> elementClass, final WebElement wrapper) {
        try {
            return findElementFor(elementClass).getDeclaredConstructor(WebElement.class).newInstance(wrapper);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <E extends AbstractElement> Class<? extends E> findElementFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(String.format("%s.%s", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
