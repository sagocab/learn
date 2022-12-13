package com.example.learn.pattern.factory_method.after;

public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
