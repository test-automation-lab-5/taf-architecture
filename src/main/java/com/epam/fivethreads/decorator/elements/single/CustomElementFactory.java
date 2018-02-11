package com.epam.fivethreads.decorator.elements.single;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.fivethreads.decorator.elements.Element;

import java.lang.reflect.InvocationTargetException;

public class CustomElementFactory {
	private static final Logger LOG = Logger.getLogger(CustomElementFactory.class);

	public <T extends Element> T create(Class<T> elementClass, WebElement wrappedElement) {
		try {
			return (T) elementClass.getDeclaredConstructor(WebElement.class).newInstance(wrappedElement);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			LOG.info(" ---- Exception in CustomElementFactory.create() ---- " + e.toString());
			return null;
		}

	}
}
