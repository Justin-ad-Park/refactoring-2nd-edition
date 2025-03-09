package com.refactoring.ch09.class03.step01;

import com.refactoring.ch09.class03.step01.Adjustment;
import com.refactoring.ch09.class03.step01.ProductionPlan;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ProductionPlanTest {

	@DisplayName("Adjustment 객체를 플랜 객체에 추가하고 production 값도 누적한다")
	@Test
	void applyAdjustment(){
	    // given
		ProductionPlan plan = new ProductionPlan(0, new ArrayList<>());
		// when
		plan.applyAdjustment(new Adjustment(1000));
	    // then
		Assertions.assertThat(plan.getProduction()).isEqualTo(1000);
		Assertions.assertThat(plan.getAdjustments().size()).isEqualTo(1);
	}

}
