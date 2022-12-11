package com.example.learn.pattern.sigletone;

import java.io.Serializable;

public class Singleton implements Serializable {
    private volatile static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    protected Object readResolve(){
        return getInstance();
    }
}
