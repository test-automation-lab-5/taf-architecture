package com.epam.decorator;

@ImplementedBy(Label.class)
public interface ILabel extends IAbstractElement {

    String getText ();
}
