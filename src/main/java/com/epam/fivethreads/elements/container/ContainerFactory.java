package com.epam.fivethreads.elements.container;

import org.openqa.selenium.WebElement;

public class ContainerFactory {
    public <T extends Container> T create(final Class<T> containerClass, final WebElement wrappedElement) {
        T container = null;
        try {
            container = containerClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        container.init(wrappedElement);
        return container;
    }
}
