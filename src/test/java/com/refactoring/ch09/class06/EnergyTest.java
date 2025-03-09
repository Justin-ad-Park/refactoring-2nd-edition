package com.refactoring.ch09.class06;

import com.refactoring.ch09.class06.Energy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EnergyTest {

	@DisplayName("potentialEnergy 계산한다")
	@Test
	void potentialEnergy(){
	    // given
		Energy energy = new Energy();
		// when
		double result = energy.potentialEnergy(1.0, 1.0);
		// then
		Assertions.assertThat(result).isEqualTo(9.81);
	}

}
