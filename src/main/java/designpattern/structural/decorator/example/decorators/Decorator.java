package designpattern.structural.decorator.example.decorators;

import designpattern.structural.decorator.example.pizza.Pizza;

public abstract class Decorator extends Pizza {

    public abstract int getCost();
    public abstract String getDescription();
}
