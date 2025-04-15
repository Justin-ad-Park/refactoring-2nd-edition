package com.refactoring.ch12.class07.origin;

public class Female extends Person {
    public Female(String name) {
        super(name);
    }

    @Override
    public String genderCode() {
        return "F";
    }
}
