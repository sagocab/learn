package com.example.learn.pattern.decorator;

public class Espresso extends Beverage{

    public Espresso(){
        description = "에스프로소";
    }

//    @Override
//    public String getDescription() {
//        return super.getDescription();
//    }

    @Override
    public double cost() {
        return 1.99;
    }
}
