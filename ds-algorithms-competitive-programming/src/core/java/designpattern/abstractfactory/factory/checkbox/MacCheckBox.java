package core.java.designpattern.abstractfactory.factory.checkbox;

public class MacCheckBox implements CheckBox {
    @Override
    public void check() {
        System.out.println("MAC Check box");
    }
}
