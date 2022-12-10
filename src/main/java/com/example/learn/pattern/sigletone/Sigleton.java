package com.example.learn.pattern.sigletone;

public class Sigleton {
    private static Sigleton instance;
    private Sigleton(){}

    public static Sigleton getInstance(Sigleton instance){
        if(instance == null){
            instance = new Sigleton();
        }
        return instance;
    }
}
