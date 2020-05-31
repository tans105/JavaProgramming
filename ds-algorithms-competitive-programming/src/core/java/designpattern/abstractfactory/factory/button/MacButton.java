package core.java.designpattern.abstractfactory.factory.button;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("MAC Button Paint");
    }
}
