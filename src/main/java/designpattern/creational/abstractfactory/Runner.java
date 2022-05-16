package designpattern.creational.abstractfactory;

import designpattern.creational.abstractfactory.factory.GUIFactory;
import designpattern.creational.abstractfactory.factory.MacFactory;
import designpattern.creational.abstractfactory.factory.WindowsFactory;

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
