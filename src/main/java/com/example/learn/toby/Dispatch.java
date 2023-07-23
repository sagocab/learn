package com.example.learn.toby;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Dispatch {
    static abstract class Service {
        abstract void run();
    }

    static class MyServie1 extends Service {
        @Override
        void run() {
            System.out.println("run1");
        }
    }

    static class MyService2 extends Service {
        @Override
        void run() {
            System.out.println("run2");
        }
    }

    public static void main(String[] args) {
        List<Service> svc = Arrays.asList(new MyServie1(), new MyService2());
        svc.forEach(Service::run);

        
    }
}
