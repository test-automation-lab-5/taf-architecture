package com.epam.decorator;

@ImplementedBy(TextInput.class)
public interface ITextInput extends IAbstractElement {

    void enterText(String string);

}
