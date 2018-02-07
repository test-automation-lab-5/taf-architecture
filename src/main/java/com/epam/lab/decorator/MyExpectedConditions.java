package com.epam.lab.decorator;

import com.epam.lab.elements.Element;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyExpectedConditions {
    public static ExpectedCondition<Element> elementToBeClickable(final Element element) {
        return new ExpectedCondition<Element>() {
            public Element apply(WebDriver driver) {
                Element visibleElement = (Element) MyExpectedConditions.visibilityOf( element ).apply( driver );

                try {
                    return visibleElement != null && visibleElement.isEnabled() ? visibleElement : null;
                } catch (StaleElementReferenceException var4) {
                    return null;
                }
            }
        };
    }
    public static ExpectedCondition<Element> visibilityOf ( final Element element){
        return new ExpectedCondition<Element>() {
            public Element apply(WebDriver driver) {
                return MyExpectedConditions.elementIfVisible( element );
            }

            public String toString() {
                return "visibility of " + element;
            }
        };
    }
    public static Element elementIfVisible(Element element) {
        return element.isDisplayed() ? element : null;
    }
}
