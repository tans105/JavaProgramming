package core.java.designpattern.creational.abstractfactory.factory;

import core.java.designpattern.creational.abstractfactory.factory.button.Button;
import core.java.designpattern.creational.abstractfactory.factory.checkbox.CheckBox;
import core.java.designpattern.creational.abstractfactory.factory.button.MacButton;
import core.java.designpattern.creational.abstractfactory.factory.checkbox.MacCheckBox;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
