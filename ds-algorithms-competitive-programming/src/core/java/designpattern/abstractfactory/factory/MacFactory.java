package core.java.designpattern.abstractfactory.factory;

import core.java.designpattern.abstractfactory.factory.button.Button;
import core.java.designpattern.abstractfactory.factory.checkbox.CheckBox;
import core.java.designpattern.abstractfactory.factory.button.MacButton;
import core.java.designpattern.abstractfactory.factory.checkbox.MacCheckBox;

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
