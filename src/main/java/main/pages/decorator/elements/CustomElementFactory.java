package main.pages.decorator.elements;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class CustomElementFactory {
    public <Element extends AbstractElement> Element create(final Class<Element> elementClass, final WebElement wrapper) {
        try {
            return findElementFor(elementClass).getDeclaredConstructor(WebElement.class).newInstance(wrapper);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <Element extends AbstractElement> Class<? extends Element> findElementFor(final Class<Element> elementClass) {
        try {
            return (Class<? extends Element>) Class.forName(String.format("%s.%s", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
