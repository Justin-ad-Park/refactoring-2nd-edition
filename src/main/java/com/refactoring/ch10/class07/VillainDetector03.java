package com.refactoring.ch10.class07;

import java.util.List;

public class VillainDetector03 {
    public static List<String> villains = List.of("Jocker", "Saruman");

    public void checkVillains(List<String> people) {
        if(hasVillains(people)) {
            alertVillain();
        }

    }

    public boolean hasVillains(List<String> people) {
        return people.stream()
                .anyMatch(villains::contains);
    }

    private static void alertVillain() {
        System.out.println("alert villain!!");
    }

}
