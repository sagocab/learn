package com.example.learn.pattern.template;

abstract class Beverage {
    // 템플릿 메소드
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    // 추상 메소드
    protected abstract void brew();

    // 구체 메소드
    private void boilWater() {
        System.out.println("물을 끓입니다.");
    }

    private void pourInCup() {
        System.out.println("컵에 따릅니다.");
    }

    // 후크 메소드 (Hook method)
    protected boolean customerWantsCondiments() {
        return true;
    }

    // 추상 메소드
    protected abstract void addCondiments();
}
