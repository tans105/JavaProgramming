package designpattern.structural.decorator.example;

import designpattern.structural.decorator.example.decorators.JapepenoDecorator;
import designpattern.structural.decorator.example.decorators.TomatoDecorator;
import designpattern.structural.decorator.example.pizza.FarmHouse;
import designpattern.structural.decorator.example.pizza.Pizza;

public class Runner {
    public static void main(String[] args) {
        Pizza pizza = new FarmHouse();
        Pizza pizza2  = new JapepenoDecorator(pizza);
        pizza2 = new TomatoDecorator(pizza2);
        //....Keep decorating dynamically


        System.out.println(pizza2.getCost());
        System.out.println(pizza2.getDescription());
    }
}
