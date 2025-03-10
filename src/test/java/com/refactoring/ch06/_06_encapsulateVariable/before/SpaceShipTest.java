package com.refactoring.ch06._06_encapsulateVariable.before;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceShipTest {

    @Test
    void SpaceShipTest() {
        Owner firstOwner = new Owner("마틴", "파울러");
        SpaceShip spaceShip = new SpaceShip(firstOwner);

        spaceShip.owner.firstName = "Justin";
        spaceShip.owner.lastName = "Park";

        assertEquals("Justin", spaceShip.owner.firstName);
        assertEquals("Park", spaceShip.owner.lastName);

        /* 객체의 값이 public으로 열려 있어 외부에서 변경됨 */
        //assertEquals("마틴", firstOwner.firstName);
        //assertEquals("파울러", firstOwner.lastName);
    }

}