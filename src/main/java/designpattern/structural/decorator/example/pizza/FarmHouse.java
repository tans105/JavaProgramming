package designpattern.structural.decorator.example.pizza;

public class FarmHouse extends Pizza {
    @Override
    public int getCost() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Farmhouse";
    }
}
