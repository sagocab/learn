package com.example.learn.action;

public class ClosureExamples {
    private int number = 999;

    public static void main(String[] args) {
        new ClosureExamples().test1();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void test1() {
         int number = 100; //effectively final

        testClosure("Annoymous Clase", new Runnable(){
            @Override
            public void run() {
                System.out.println(ClosureExamples.this.number);
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(this.number));

    }

    private static void testClosure(String name, Runnable runnable){
        System.out.println("Start :"+ name +":");
        runnable.run();
    }

}
