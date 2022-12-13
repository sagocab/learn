package com.example.learn.pattern.factory_method.after;

public class Client {

    public static void main(String[] args) {
        Ship whitShip = new WhiteShipFactory().orderShip("whitShip", "aaaa@ddd.clm");
        System.out.println(whitShip.toString());

        Ship blackShip = new BlackShipFactory().orderShip("blackShip", "bbb@aaa.com");
        System.out.println(blackShip.toString());
    }
}
