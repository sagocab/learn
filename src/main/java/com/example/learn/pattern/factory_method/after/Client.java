package com.example.learn.pattern.factory_method.after;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.Print(new WhiteShipFactory(), "whitShip", "aaaa@ddd.clm");
        client.Print(new BlackShipFactory(), "blackShip", "bbb@aaa.com");
//        Ship whitShip = new WhiteShipFactory().orderShip("whitShip", "aaaa@ddd.clm");
//        System.out.println(whitShip.toString());
//
//        Ship blackShip = new BlackShipFactory().orderShip("blackShip", "bbb@aaa.com");
//        System.out.println(blackShip.toString());
    }

    private void Print(ShipFactory factory, String name, String email) {
        System.out.println(factory.orderShip(name, email));
    }
}
