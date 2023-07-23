package com.example.learn.pattern.template;

public class Coffe extends Beverage{
    @Override
    protected void brew() {
        System.out.println("필터로 커피를 우려내는 중...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("설탕과 우유를 추가하는 중...");
    }
}
