package com.example.learn.pattern.sigletone;

public enum Settings {
    INSTANCE;

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
