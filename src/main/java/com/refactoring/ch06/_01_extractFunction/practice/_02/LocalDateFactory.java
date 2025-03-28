package com.refactoring.ch06._01_extractFunction.practice._02;

import java.time.LocalDate;

public interface LocalDateFactory {
    default LocalDate now() {
        return LocalDate.now();
    }
}
