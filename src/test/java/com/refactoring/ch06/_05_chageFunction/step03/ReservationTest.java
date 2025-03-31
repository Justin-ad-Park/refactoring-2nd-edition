package com.refactoring.ch06._05_chageFunction.step03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

class ReservationTest {

	@DisplayName("add reservation with customer to the firstServedReservations queue")
	@Test
	void addReservation(){
	    // given
		Reservation reservation = new Reservation();
		Customer kim = new Customer("kim");
		Customer lee = new Customer("lee");
		Customer park = new Customer("park");
		// when
		reservation.addReservation(kim, false);
		reservation.addReservation(lee, false);
		reservation.addReservation(park, false);
	    // then
		String customerNames = reservation.getReservations().stream()
			.map(Customer::getName)
			.collect(Collectors.joining(", "));
		Assertions.assertThat(customerNames).isEqualTo("kim, lee, park");
	}
}
