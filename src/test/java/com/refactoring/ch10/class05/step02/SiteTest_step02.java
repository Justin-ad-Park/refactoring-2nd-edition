package com.refactoring.ch10.class05.step02;

import com.refactoring.ch10.class05.before.Customer;
import com.refactoring.ch10.class05.before.PaymentHistory;
import com.refactoring.ch10.class05.before.Plan;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SiteTest_step02 {
	@DisplayName("고객이 거주하는 공간(site)에 고객이 미확인 고객이면 고객 이름을 거주자로 변경한다")
	@Test
	void 미확인고객_이름변경to거주자(){
		// given
		Site site = new Site(new Customer("미확인 고객", new Plan("요금제", 50), new PaymentHistory(false, 0)));

		// when
		String customerName = site.getCustomer().getName();

		// then
		Assertions.assertThat(customerName).isEqualTo("거주자");
	}

	@DisplayName("거주하는 공간의 고객이 미확인 고객은 기본 요금으로 계산한다")
	@Test
	void 미확인고객_요금제_기본플랜변경(){
		// given
		Site site = new Site(new Customer("미확인 고객", new Plan("요금제", 50), new PaymentHistory(false, 0)));

		// when
		Plan plan = site.getCustomer().billingPlan();

		// then
		Assertions.assertThat(plan).isEqualTo(new Plan("basic", 100));
	}


	@DisplayName("미확인 고객이 아니면 히스토리를 통해서 지연 주수를 계산한다")
	@Test
	void 정상고객_연체누적주_확인(){
		// given
		Site site = new Site(new Customer("kim", new Plan("요금제", 50), new PaymentHistory(true, 2)));

		// when
		int weeksDelinquent = site.getCustomer().getPaymentHistory().getWeeksDelinquentInLastYear();

		// then
		Assertions.assertThat(weeksDelinquent).isEqualTo(2);
	}

	@DisplayName("미확인 고객의 지연 주수는 0이다")
	@Test
	void 미확인고객_연체주수_zero(){
		// given
		Site site = new Site(new Customer("미확인 고객", new Plan("요금제", 50), new PaymentHistory(true, 2)));

		// when
		int weeksDelinquent = site.getCustomer().getPaymentHistory().getDelinquentWeeks();

		// then
		Assertions.assertThat(weeksDelinquent).isZero();
	}

}
