package com.epam.decorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;


@ImplementedBy(AbstractElement.class)
public interface IAbstractElement extends WebElement, WrapsElement {
    /**
     * Returns true when the inner element is ready to be used.
     *
     * @return boolean true for an initialized WebElement, or false if we were somehow passed a null WebElement.
     */
    boolean elementWired();
}
