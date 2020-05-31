package core.java.designpattern.abstractfactory;

import core.java.designpattern.abstractfactory.factory.GUIFactory;
import core.java.designpattern.abstractfactory.factory.MacFactory;
import core.java.designpattern.abstractfactory.factory.WindowsFactory;

public class Runner {
    public static void main(String[] args) {
        String os = "Mac";
        GUIFactory factory;
        Application app;

        if ("Windows".equals(os)) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }


        app = new Application(factory);
        app.buildUI();
    }
}
