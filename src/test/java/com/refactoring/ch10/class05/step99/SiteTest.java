package com.refactoring.ch10.class05.step99;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class SiteTest {
	@DisplayName("고객이 거주하는 공간(site)에 고객이 미확인 고객이면 고객 이름을 거주자로 변경한다")
	@Test
	void changeCustomerNameToResident_WhenCustomerIsUnidentifiedAndResidingInSite(){
	    // given
		String name = "물류창고 15";
		String location = "Malden MA";
		Site site = new Site(name, location, new Customer(true, "미확인 고객", new Plan("요금제", 50), new PaymentHistory(false, 0)));
		Customer customer = site.getCustomer();
		// when
		String customerName = customer.getName();
	    // then
		Assertions.assertThat(customerName).isEqualTo("거주자");
	}

	private boolean isUnknown(Customer customer) {
		if (customer.getName().equals("미확인 고객")){
			return true;
		}
		return customer.isUnknown();
	}

	@DisplayName("거주하는 공간의 고객이 미확인 고객은 기본 요금으로 계산한다")
	@Test
	void calculateDefaultRate_WhenCustomerIsUnidentifiedInSite(){
	    // given
		String name = "물류창고 15";
		String location = "Malden MA";
		Site site = new Site(name, location, Customer.create("미확인 고객"));
		Customer customer = site.getCustomer();
		// when
		Plan plan = customer.getBillingPlan();
	    // then
		Assertions.assertThat(plan).isEqualTo(new Plan("basic", 100));
	}

	@DisplayName("고객이 미확인 고객이 아닌 고객은 새로운 요금제를 설정한다")
	@Test
	void SetNewRatePlan_WhenCustomerIsIdentified(){
	    // given
		String name = "물류창고 15";
		String location = "Malden MA";
		Site site = new Site(name, location, new Customer(false, "kim", new Plan("요금제", 50), new PaymentHistory(false, 0)));
		Customer customer = site.getCustomer();
	    // when
		if (!isUnknown(customer)){
			customer.setBillingPlan(new Plan("special", 200));
		}
	    // then
		Assertions.assertThat(customer.getBillingPlan()).isEqualTo(new Plan("special", 200));
	}

	@DisplayName("고객이 미확인 고객이면 지연 주수가 0이고 미확인 고객이 아니면 히스토리를 통해서 지연 주수를 계산한다")
	@Test
	void calculateDelayWeeks_WhenCustomerIsIdentifiedOrSetToZeroIfUnidentified(){
	    // given
		String name = "물류창고 15";
		String location = "Malden MA";
		Site site = new Site(name, location, new Customer(false, "kim", new Plan("요금제", 50), new PaymentHistory(true, 2)));
		Customer customer = site.getCustomer();
	    // when
		int weeksDelinquent = customer.getPaymentHistory().getWeeksDelinquentInLastYear();
	    // then
		Assertions.assertThat(weeksDelinquent).isEqualTo(2);
	}

	@DisplayName("미확인 고객의 지연 주수는 0이다")
	@Test
	void calculateWeeksDelinquent_WhenCustomerIsIdentified(){
		// given
		String name = "물류창고 15";
		String location = "Malden MA";
		Site site = new Site(name, location, Customer.create("미확인 고객"));
		Customer customer = site.getCustomer();
		// when
		int weeksDelinquent = customer.getPaymentHistory().getWeeksDelinquentInLastYear();
		// then
		Assertions.assertThat(weeksDelinquent).isZero();
	}

	@DisplayName("거주 공간 데이터를 파싱한 다음에 고객이 미확인 고객이라면 고객의 이름은 거주자이다")
	@Test
	void setCustomerNameToResident_WhenCustomerIsUnidentifiedAfterParsingSiteData(){
	    // given
		Site rawSite = acquireSiteData();
		Site site = enrichSite(rawSite);
		Customer customer = site.getCustomer();
		// when
		String customerName = customer.getName();
	    // then
		Assertions.assertThat(customerName).isEqualTo("거주자");
	}

	private Site acquireSiteData() {
		Map<String, String> map = Map.of(
			"name", "물류창고 15",
			"location", "Malden MA",
			"customer", "미확인 고객"
		);

		String name = map.get("name");
		String location = map.get("location");
		return new Site(name, location, new Customer(true, "미확인 고객", new Plan("basic", 100), new PaymentHistory(false, 0)));
	}

	private Site enrichSite(Site site) {
		Site result = cloneDeep(site);
		Customer unknownCustomer = new UnknownCustomer();
		if (isUnknown(result.getCustomer())){
			result.setCustomer(unknownCustomer);
		}else{
			result.getCustomer().setIsUnknown(false);
		}
		return result;
	}

	private Site cloneDeep(Site site) {
		Customer customer = site.getCustomer();
		Plan plan = customer.getBillingPlan();
		PaymentHistory paymentHistory = customer.getPaymentHistory();
		return new Site(
			site.getName(),
			site.getLocation(),
			new Customer(customer.isUnknown(), customer.getName(),
				new Plan(plan.getName(), plan.getAmount()),
				new PaymentHistory(paymentHistory.isDelinquent(), paymentHistory.getDelinquentWeeks())
			)
		);
	}
}
