package com.example.learn.pattern.decorator;

public class Soy extends CondimentDecorator{
    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 2.0 + beverage.cost() ;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 두유";
    }
}
