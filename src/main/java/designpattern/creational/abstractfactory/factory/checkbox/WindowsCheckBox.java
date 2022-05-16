package designpattern.creational.abstractfactory.factory.checkbox;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void check() {
        System.out.println("Windows check box");
    }
}
