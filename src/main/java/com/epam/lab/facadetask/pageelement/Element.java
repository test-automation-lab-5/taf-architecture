package com.epam.lab.facadetask.pageelement;

import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    // универсальные методы для всех элементов
}