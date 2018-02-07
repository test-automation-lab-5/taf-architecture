package epam.com.pomgmail.pomdecorator;

import epam.com.pomgmail.pomdecorator.AbstractElement;
import org.openqa.selenium.WebElement;;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    private DefaultElementFactory elementFactory = new DefaultElementFactory();

    public CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (AbstractElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, this.factory.createLocator(field));
        return elementFactory.create((Class<? extends AbstractElement>) field.getType(), wrappedElement);
    }

//    private ElementLocator createLocator(final Field field) {
//        return factory.createLocator(field);
//    }



//    public CustomFieldDecorator(SearchContext searchContext) {
//        super(new DefaultElementLocatorFactory(searchContext));
//    }
//
//    @Override
//    public Object decorate(ClassLoader loader, Field field) {
//        Class<?> decoratableClass = decoratableClass(field);
//        if (decoratableClass != null) {
//            ElementLocator locator = factory.createLocator(field);
//            if (locator == null) {
//                return null;
//            }
//            return createElement(loader, locator, decoratableClass);
//        }
//        return super.decorate(loader, field);
//    }
//
//    private Class<?> decoratableClass(Field field) {
//
//        Class<?> clazz = field.getType();
//
//        try {
//            clazz.getConstructor(WebElement.class);
//        } catch (Exception e) {
//            return null;
//        }
//        return clazz;
//    }
//
//    private <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> clazz) {
//        WebElement proxy = proxyForLocator(loader, locator);
//        return createInstance(clazz, proxy);
//    }
//
//    private <T> T createInstance(Class<T> clazz, WebElement element) {
//        try {
//            return (T) clazz.getConstructor(WebElement.class).newInstance(element);
//        } catch (Exception e) {
//            throw new AssertionError(String.format("WebElement can't be represented as  %s", clazz));
//        }
//    }
}
