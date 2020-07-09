package core.java.designpattern.abstractfactory.factory;

import core.java.designpattern.abstractfactory.factory.button.Button;
import core.java.designpattern.abstractfactory.factory.checkbox.CheckBox;
import core.java.designpattern.abstractfactory.factory.button.WindowsButton;
import core.java.designpattern.abstractfactory.factory.checkbox.WindowsCheckBox;

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
