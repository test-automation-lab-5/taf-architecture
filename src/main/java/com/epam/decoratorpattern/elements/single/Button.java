package com.epam.decoratorpattern.elements.single;

import org.openqa.selenium.WebElement;

import com.epam.decoratorpattern.elements.Element;

public class Button implements Element{
	protected WebElement wrappedElement;

	protected Button(WebElement wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void click() {
		wrappedElement.click();
	}

	public boolean isDisplayed() {
		return wrappedElement.isDisplayed();
	}
}
