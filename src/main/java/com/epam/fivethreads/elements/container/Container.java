package com.epam.fivethreads.elements.container;

import org.openqa.selenium.WebElement;

import com.epam.fivethreads.elements.Element;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
