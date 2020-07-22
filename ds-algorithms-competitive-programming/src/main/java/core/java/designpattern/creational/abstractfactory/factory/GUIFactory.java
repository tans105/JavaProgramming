package core.java.designpattern.creational.abstractfactory.factory;

import core.java.designpattern.creational.abstractfactory.factory.button.Button;
import core.java.designpattern.creational.abstractfactory.factory.checkbox.CheckBox;

public interface GUIFactory {

    Button createButton();

    CheckBox createCheckBox();
}
