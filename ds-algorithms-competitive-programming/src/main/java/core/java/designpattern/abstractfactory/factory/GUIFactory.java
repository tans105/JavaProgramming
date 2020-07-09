package core.java.designpattern.abstractfactory.factory;

import core.java.designpattern.abstractfactory.factory.button.Button;
import core.java.designpattern.abstractfactory.factory.checkbox.CheckBox;

public interface GUIFactory {

    Button createButton();

    CheckBox createCheckBox();
}
