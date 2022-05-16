package designpattern.structural.decorator.example.decorators;

import designpattern.structural.decorator.example.pizza.Pizza;

public class JapepenoDecorator extends Decorator {

    Pizza pizza;

    public JapepenoDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 50;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "+" + "Jalepeno";
    }
}
