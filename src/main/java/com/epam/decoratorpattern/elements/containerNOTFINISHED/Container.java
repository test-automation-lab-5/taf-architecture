package com.epam.decoratorpattern.elements.containerNOTFINISHED;

import org.openqa.selenium.WebElement;

import com.epam.decoratorpattern.elements.Element;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
