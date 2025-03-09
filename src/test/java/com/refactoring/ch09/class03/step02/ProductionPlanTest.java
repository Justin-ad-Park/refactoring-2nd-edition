package com.refactoring.ch09.class03.step02;

import com.refactoring.ch09.class03.step02.Adjustment;
import com.refactoring.ch09.class03.step02.ProductionPlan;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ProductionPlanTest {

	@DisplayName("ProductionPlan에서 production의 값은 0이다")
	@Test
	void getProduction(){
	    // given
		ProductionPlan productionPlan = new ProductionPlan(0, new ArrayList<>());
		// when
		int result = productionPlan.getProduction();
		// then
		Assertions.assertThat(result).isEqualTo(0);
	}

	@DisplayName("1000원을 누적한다")
	@Test
	void applyAdjustment(){
		// given
		ProductionPlan productionPlan = new ProductionPlan(0, new ArrayList<>());
		// when
		productionPlan.applyAdjustment(new Adjustment(1000));
		// then
		Assertions.assertThat(productionPlan.getProduction()).isEqualTo(1000);
	}

}
