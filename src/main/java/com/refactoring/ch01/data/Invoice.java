package com.refactoring.ch01.data;

import java.util.List;

public record Invoice(
        String customer,
        List<Performance> performances
) {
}
