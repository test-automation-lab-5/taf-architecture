package com.epam.fivethreads.decorator.elements.container;

import org.openqa.selenium.WebElement;

import com.epam.fivethreads.decorator.elements.Element;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
