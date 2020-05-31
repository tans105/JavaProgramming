package core.java.designpattern.abstractfactory.factory.button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows Button");
    }
}
