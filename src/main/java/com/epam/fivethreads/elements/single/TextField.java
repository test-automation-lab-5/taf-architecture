package com.epam.fivethreads.elements.single;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.epam.fivethreads.elements.Element;

public class TextField implements Element{
	protected WebElement wrappedElement;

	protected TextField(WebElement wrappedElement) {
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

	public void click() {
		wrappedElement.click();

	}

	public void type(Keys keys) {
		wrappedElement.sendKeys(keys);

	}

	public boolean isDisplayed() {
		return wrappedElement.isDisplayed();
	}
}
