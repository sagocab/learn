package com.example.learn.pattern.template;

public class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("차를 우려내는 중...");
    }

    @Override
    protected boolean customerWantsCondiments() {
        // 사용자의 입력이나 다른 조건을 통해 결과를 결정할 수 있습니다.
        return false;
    }

    @Override
    protected void addCondiments() {
        System.out.println("레몬을 추가하는 중...");
    }
}
