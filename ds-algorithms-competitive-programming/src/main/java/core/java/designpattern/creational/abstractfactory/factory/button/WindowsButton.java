package core.java.designpattern.creational.abstractfactory.factory.button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows Button");
    }
}
