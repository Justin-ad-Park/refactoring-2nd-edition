package com.refactoring.ch10.class07;

import org.junit.jupiter.api.Test;
import java.util.List;

class VillainDetector00Test {
    @Test
    void checkVillain() {
        // given
        VillainDetector00 detector = new VillainDetector00();

        List<String> people = List.of("Pooh", "Penguin", "Jocker", "Tiger");

        detector.checkVillains(people);
    }

}