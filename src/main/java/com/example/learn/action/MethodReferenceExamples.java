package com.example.learn.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1,2,3,4,5)
                .forEach(System.out::println);
//        String temp = null;
//        String newName = getName(Objects.requireNonNull(temp));
//        System.out.println(newName);

        ArrayList<String> list = null;
//        list.add("a");
        String newName = getName(Objects.requireNonNull(list));
    }

    private static String getName(ArrayList<String> list){

        return list.toString();
    }

}
