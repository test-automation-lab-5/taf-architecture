package com.epam.decoratorpattern.elements.containerNOTFINISHED;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.epam.decoratorpattern.businessobjects.BasicBO;

public class OldCustomFieldDecorator extends DefaultFieldDecorator{
	private static final Logger LOG = Logger.getLogger(OldCustomFieldDecorator.class);
	
	public OldCustomFieldDecorator(SearchContext searchContext) {
		super(new DefaultElementLocatorFactory(searchContext));

	}
//Метод викликається фабрикою для кожного поля в класі
	@Override
	public Object decorate(ClassLoader loader, Field field) {
		Class<?> decorableClass = decorableClass(field);
		//якщо поля класу підлягають декорації
		if (decorableClass!=null) {
			ElementLocatorFactory locator=(ElementLocatorFactory) factory.createLocator(field);
			if (locator==null) {
				return null;
			}
			//елемент
			return createElement(loader,locator,decorableClass);
		}
		return super.decorate(loader, field);		
	}
	//створення елемента
	//знаходить WebElement та передає його в кастомний клас
	private <T> T createElement(ClassLoader loader, ElementLocatorFactory locator, Class<T> clazz) {
		WebElement proxy=proxyForLocator(loader,(ElementLocator) locator);
		return createInstance(clazz,proxy);
	}
	
	//створює екземпляр класу
	//викликаючи конструктор з ергументом WebElement
	private <T> T createInstance(Class<T> clazz, WebElement element) {
		try {
			return (T) clazz.getConstructor(WebElement.class).newInstance(element);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			LOG.info(" ---- Exception in CustomFieldDecorator.createInstance() ---- ");
			return null;
		}		
	}
	//Повертає  клас-декоратор для поля, 
	//або нулл, якщо клас не підходить для декоратора
	private Class<?> decorableClass(Field field) {		
		Class<?> clazz=field.getType();
		//у елемента повинен бути конструктор, що приймає WebElement		
		try {
			clazz.getConstructor(WebElement.class);
		} catch (NoSuchMethodException | SecurityException e) {
			LOG.info(" ---- Exception in CustomFieldDecorator.decorableClass() ---- ");
			e.printStackTrace();	
			return null;
		}
		return clazz;
	}
}
