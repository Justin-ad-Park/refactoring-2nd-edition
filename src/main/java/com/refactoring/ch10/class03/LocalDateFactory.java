package com.refactoring.ch10.class03;

import java.time.LocalDate;

public interface LocalDateFactory {
    default LocalDate now() {
        return LocalDate.now();
    }
}
