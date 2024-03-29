package com.example.learn.action;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SreamExamples5Parallel {
    public static void main(String[] args) {
        final int[] sum = {0};
        IntStream.range(0,100)
                .forEach(i -> sum[0] += i);

        System.out.println("                   stream sum :" +sum[0]);

        final int[] sum2 = {0};
        IntStream.range(0,100)
                .parallel()
                .forEach(i -> sum2[0] += i);
        System.out.println("paralle sum(with side-effect) :" +sum2[0]);

        System.out.println("stream sum(no side-effect) :"+
                IntStream.range(0,100)
                .sum());

        System.out.println("parallel stream sum(no side-effect) :"+
                IntStream.range(0,100)
                        .parallel()
                        .sum());

        System.out.println("\n============================");
        System.out.println("Stream");
        final long start = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream()
                .map(i -> {
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("\n============================");
        System.out.println("Parallel Stream");
        final long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start2);
    }
}
