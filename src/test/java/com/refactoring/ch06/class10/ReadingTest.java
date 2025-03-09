package com.refactoring.ch06.class10;

import com.refactoring.ch06.class10.EnrichReading;
import com.refactoring.ch06.class10.Reading;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReadingTest {

	@DisplayName("calculate baesCharge for reading")
	@Test
	void enrichReading(){
	    // given
		String customer = "kim";
		int quantity = 10;
		int month = 8;
		int year = 2024;
		// when
		EnrichReading enrichReading = Reading.enrichReading(customer, quantity, month, year);
		// then
		Assertions.assertThat(enrichReading.getBaseCharge()).isCloseTo(1.8, Offset.offset(0.1));
		Assertions.assertThat(enrichReading.getTaxableCharge()).isCloseTo(1.6, Offset.offset(0.1));
	}
}
