package com.example.learn.action;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExamples5ParallelPerformance {
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i < n; i++) {
            result += i+1;
        }
        return result;
    }

    public static long sequentialSum(long n){
        return Stream.iterate(1L, i -> i+1).limit(n).reduce(Long::sum).get();
    }

    public static long parallelSum(long n){
        return Stream.iterate(1l, i-> i+1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1,n).parallel().reduce(Long::sum).getAsLong();
    }

    public static void main(String[] args) {
        final long n = 10_000_000;
        System.out.println((1+n)*(n/2));
//        System.out.println(());
        long start = System.currentTimeMillis();
        System.out.println("iterativeSum : "+iterativeSum(n));
        System.out.println("             "+(System.currentTimeMillis() - start)+"ms\n");
//        long start2 = System.currentTimeMillis();
//        System.out.println("sequentialSum : "+sequentialSum(n));
//        System.out.println("             "+(System.currentTimeMillis() - start2)+"ms\n");
    }
}
