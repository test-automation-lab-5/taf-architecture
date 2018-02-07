package com.epam.fivethreads.customfielddecorator;

import java.lang.reflect.Field;

import com.epam.fivethreads.elements.container.Container;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

import com.epam.fivethreads.elements.Element;
import com.epam.fivethreads.elements.container.ContainerFactory;
import com.epam.fivethreads.elements.single.CustomElementFactory;

public class CustomFieldDecorator extends DefaultFieldDecorator {
	private static final Logger LOG = Logger.getLogger(CustomFieldDecorator.class);
	private CustomElementFactory elementFactory = new CustomElementFactory();
	private ContainerFactory containerFactory = new ContainerFactory();

	public CustomFieldDecorator(SearchContext searchContext) {
		super(new DefaultElementLocatorFactory(searchContext));
	}

	@Override
	public Object decorate(ClassLoader loader, Field field) {
		//LOG.info(" ---- ExtendedFieldDecorator.decorate() ---- " + field.getName() + " ="
		//		+ field.getType().getSimpleName());
		// якщо поле є нащадком Container то працюємо з  контейнером елементів

		if (Container.class.isAssignableFrom(field.getType())) {
			WebElement wrappedElement = proxyForLocator(loader, factory.createLocator(field));
			Container container = containerFactory.create((Class<? extends Container>) field.getType(), wrappedElement);
			PageFactory.initElements(new CustomFieldDecorator(wrappedElement), container);
			return container;

		} // якщо поле є нащадком Element то працюємо з елементом

		if (Element.class.isAssignableFrom(field.getType())) {
			WebElement wrappedElement = proxyForLocator(loader, factory.createLocator(field));
			return elementFactory.create((Class<? extends Element>) field.getType(), wrappedElement);

		}
		// якщо не є нащадком ні Container ні Element викликаємо метод оригінальний decorate
		return super.decorate(loader, field);
	}

}
