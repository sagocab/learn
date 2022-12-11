package com.example.learn.pattern.sigletone;

public class Singleton2 {
    private Singleton2() {}

    private static class Sigleton2Holder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return Sigleton2Holder.INSTANCE;
    }
}

