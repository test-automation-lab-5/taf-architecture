package com.epam.decorator;

@ImplementedBy(Button.class)
public interface IButton extends  IAbstractElement {

    void clickOn();


}
