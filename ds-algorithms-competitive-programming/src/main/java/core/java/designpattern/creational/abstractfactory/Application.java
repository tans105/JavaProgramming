package core.java.designpattern.creational.abstractfactory;

import core.java.designpattern.creational.abstractfactory.factory.GUIFactory;

public class Application {
    GUIFactory factory;

    Application(GUIFactory factory) {
        this.factory = factory;
    }

    public void buildUI() {
        factory.createButton().paint();
        factory.createCheckBox().check();
    }

}
