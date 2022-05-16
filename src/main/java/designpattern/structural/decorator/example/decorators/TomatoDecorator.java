package designpattern.structural.decorator.example.decorators;

import designpattern.structural.decorator.example.pizza.Pizza;

public class TomatoDecorator extends Decorator {
    Pizza pizza;

    public TomatoDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 80;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "+" + "Tomato";
    }
}
