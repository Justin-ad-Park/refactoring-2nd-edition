package com.refactoring.ch10.class07;

import java.util.List;

public class VillainDetector00 {
    public void checkVillains(List<String> people) {

        boolean found = false;
        for(String person : people) {
            if(!found) {
                if(person.equals("Jocker")) {
                    found = true;
                    alertVillain();
                }

                if(person.equals("Saruman")) {
                    found = true;
                    alertVillain();
                }
            }
        }

    }

    private void alertVillain() {
        System.out.println("alert villain!!");
    }

}
