package com.example.learn.pattern.template;

public class TemplateMethodExample {
    public static void main(String[] args) {
        Beverage coffe = new Coffe();
        System.out.println("커피를 만듭니다.");
        coffe.prepareBeverage();
        System.out.println();

        Beverage tea = new Tea();
        System.out.println("차를 만듭니다.");
        tea.prepareBeverage();
    }
}
