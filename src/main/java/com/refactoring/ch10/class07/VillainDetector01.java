package com.refactoring.ch10.class07;

import java.util.List;

public class VillainDetector01 {
    public void checkVillains(List<String> people) {
        if(hasVillains(people)) {
            alertVillain();
        }

    }

    public boolean hasVillains(List<String> people) {

        for(String person : people) {
                if(person.equals("Jocker")) return true;
                if(person.equals("Saruman")) return true;
        }
        return false;

    }

    private static void alertVillain() {
        System.out.println("alert villain!!");
    }

}
