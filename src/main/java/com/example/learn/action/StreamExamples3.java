package com.example.learn.action;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples3 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 5, 5);

        System.out.println(
                integers.stream()
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#"+ i)
                .collect(toList())
        );
        System.out.println(
                integers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#"+ i)
                        .collect(toSet())
        );
        System.out.println(
                integers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#"+ i)
                        .collect(joining())
        );
        System.out.println(
                integers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#"+ i)
                        .collect(joining(", "))
        );
        System.out.println(
                integers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#"+ i)
                        .collect(joining(", ","[","]"))
        );
        System.out.println(
                integers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#"+ i)
                        .distinct()
                        .collect(joining(", ","[","]"))
        );
        System.out.println(
                integers.stream()
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#"+ i)
                        .distinct()
                        .collect(toList())
        );
        final Integer integer3 = 3;
        System.out.println(
                Stream.of(1,2,3,4,5)
                        .filter(i -> i == integer3)
                        .findFirst()
        );
        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1,2,3,4,5, 127)
                        .filter(i -> i == integer127)
                        .findFirst()
        );
        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1,2,3,4,5, 128)
                        .filter(i -> i == integer128)
                        .findFirst()
        );

        System.out.println(
                Stream.of(1,2,3,4,5, 128)
                        .filter(i -> i.equals(integer128))
                        .findFirst()
        );
        System.out.println(
                Stream.of(1,2,3,4,5)
                        .filter(i -> i > 3)
                        .count()
        );

        System.out.println("forEach(i -> System.out.println(i))");
        Stream.of(1,2,3,4,5)
                .forEach(i -> System.out.println(i))
                ;
    }
}
