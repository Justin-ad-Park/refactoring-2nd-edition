package com.refactoring.ch12.class07.step02;

public class Female extends Person {
    public Female(String name) {
        super(name, "F");
    }

    @Override
    public String genderCode() {
        return "F";
    }
}
