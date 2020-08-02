package designpattern.creational.abstractfactory.factory;

import designpattern.creational.abstractfactory.factory.button.Button;
import designpattern.creational.abstractfactory.factory.checkbox.CheckBox;

public interface GUIFactory {

    Button createButton();

    CheckBox createCheckBox();
}
