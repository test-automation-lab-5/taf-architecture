package com.epam.fivethreads.decorator.elements.single;

import com.epam.fivethreads.pages.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.fivethreads.decorator.elements.Element;

public class Button implements Element{
	private static final Logger LOG = Logger.getLogger(Button.class);
	protected WebElement wrappedElement;
		private String name;

	protected Button(WebElement wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void click() {
		LOG.info(String.format("Button %s click()",name));
		wrappedElement.click();
	}

	public boolean isDisplayed() {
		return wrappedElement.isDisplayed();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}