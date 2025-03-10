package com.refactoring.ch06._06_encapsulateVariable.after;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpaceShipTest {

	@DisplayName("change the defaultOwner's info")
	@Test
	void defaultOwner(){
	    // given
		Owner firstOwner = new Owner("마틴", "파울러");
		SpaceShip spaceShip = new SpaceShip(firstOwner);
		// when
	    spaceShip.setOwner(new Owner("Justin", "Park"));
	    // then
		Assertions.assertThat(spaceShip.getOwner().getFirstName()).isEqualTo("Justin");
		Assertions.assertThat(spaceShip.getOwner().getLastName()).isEqualTo("Park");

		Assertions.assertThat(firstOwner.getFirstName()).isEqualTo("마틴");
		Assertions.assertThat(firstOwner.getLastName()).isEqualTo("파울러");

	}

}
