package com.refactoring.ch12.class07.step02;

public class Male extends Person {
    public Male(String name) {
        super(name, "M");
    }

    @Override
    public String genderCode() {
        return "M";
    }
}
