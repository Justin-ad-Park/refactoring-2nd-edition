package com.refactoring.ch12.class07.origin;

public class Male extends Person {
    public Male(String name) {
        super(name);
    }

    @Override
    public String genderCode() {
        return "M";
    }
}
