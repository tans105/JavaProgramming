package core.java.designpattern.creational.abstractfactory.factory;

import core.java.designpattern.creational.abstractfactory.factory.button.Button;
import core.java.designpattern.creational.abstractfactory.factory.checkbox.CheckBox;
import core.java.designpattern.creational.abstractfactory.factory.button.WindowsButton;
import core.java.designpattern.creational.abstractfactory.factory.checkbox.WindowsCheckBox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
