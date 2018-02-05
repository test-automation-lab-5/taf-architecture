package com.epam.decoratorpattern.elements.single;

import org.openqa.selenium.WebElement;

import com.epam.decoratorpattern.elements.Element;

public class InputTextField implements Element{
	protected WebElement wrappedElement;

	protected InputTextField(WebElement wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void type(String text) {
		wrappedElement.sendKeys(text);
	}

	public void clear() {
		wrappedElement.clear();
	}

	public void clearAndType(String text) {
		clear();
		type(text);
	}

	public boolean isDisplayed() {
		return wrappedElement.isDisplayed();
	}
}
