package designpattern.structural.decorator.example.pizza;

public class PeppyPaneer extends Pizza {
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Peppy Paneer";
    }
}
