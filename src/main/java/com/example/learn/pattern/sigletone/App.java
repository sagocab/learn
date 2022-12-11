package com.example.learn.pattern.sigletone;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton singleton1 = Singleton.getInstance();

        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton = constructor.newInstance();

        System.out.println(singleton == singleton1);//false

        Settings settings1 = Settings.INSTANCE;
        Settings settings2 = Settings.INSTANCE;
        System.out.println(settings1 == settings2);//true

        settings1.setNumber(3);
        System.out.println(settings1.getNumber());
    }
}
