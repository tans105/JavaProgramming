package designpattern.creational.abstractfactory.factory;

import designpattern.creational.abstractfactory.factory.button.Button;
import designpattern.creational.abstractfactory.factory.checkbox.CheckBox;
import designpattern.creational.abstractfactory.factory.button.WindowsButton;
import designpattern.creational.abstractfactory.factory.checkbox.WindowsCheckBox;

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
