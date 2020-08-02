package designpattern.creational.abstractfactory.factory;

import designpattern.creational.abstractfactory.factory.button.Button;
import designpattern.creational.abstractfactory.factory.checkbox.CheckBox;
import designpattern.creational.abstractfactory.factory.button.MacButton;
import designpattern.creational.abstractfactory.factory.checkbox.MacCheckBox;

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
