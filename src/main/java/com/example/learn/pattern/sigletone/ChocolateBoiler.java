package com.example.learn.pattern.sigletone;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler instance;

    private ChocolateBoiler() {
        empty = true;
        boiled = true;
    }

    public static ChocolateBoiler getInstance(){
        if(instance == null){
            instance = new ChocolateBoiler();
        }
        return instance;
    }

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(!isEmpty() && isBoild()){
            boiled = true;
        }
    }

    public void boil(){
        if(!isEmpty() && !isBoild()){
            boiled = true;
        }
    }


    private boolean isBoild() {
        return boiled;
    }

    private boolean isEmpty() {
        return empty;
    }
}
