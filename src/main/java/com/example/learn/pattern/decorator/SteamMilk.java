package com.example.learn.pattern.decorator;

public class SteamMilk extends CondimentDecorator{
    Beverage beverage;

    public SteamMilk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1.8 + beverage.cost() ;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 스팀밀크";
    }
}