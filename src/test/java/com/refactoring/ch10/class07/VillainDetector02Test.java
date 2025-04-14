package com.refactoring.ch10.class07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VillainDetector02Test {

    @Test
    void hasVillains() {
        // given
        VillainDetector02 detector = new VillainDetector02();

        // when
        List<String> people = List.of("Pooh", "Penguin", "Jocker", "Tiger");
        boolean found = detector.hasVillains(people);

        // then
        Assertions.assertTrue(found);
    }

}