package com.refactoring.ch07.class01.step02;

import com.refactoring.ch07.class01.step02.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CustomerTest {

	@DisplayName("사용자는 고객 정보를 작성한다")
	@Test
	void test1(){
	    // given
		Map<String, Map<String, Object>> customerData = new HashMap<>();
		Map<String, Object> martin = new HashMap<>();
		Map<String, Map<String, Integer>> martinUsages = new HashMap<>();
		Map<String, Integer> martinMonthlyUsage = new HashMap<>();
		int value = 50;
		for (int i = 1; i <= 12; i++){
			martinMonthlyUsage.put(String.valueOf(i), value);
			value += 5;
		}
		martinUsages.put("2016", martinMonthlyUsage);
		martinUsages.put("2015", martinMonthlyUsage);

		martin.put("name", "Martin");
		martin.put("id", "1920");
		martin.put("usages", martinUsages);
		customerData.put("1920", martin);
		Customer customer = new Customer(customerData);
		// when
		String customerId = "1920";
		Map<String, Map<String, Integer>> usages = (Map<String, Map<String, Integer>>)customerData.get(customerId).get("usages");
		String year = "2016";
		String month = "1";
		int amount = 10;
		usages.get(year).put(month, amount);

		Map<String, Integer> result = customer.compareUsage(customerId, year, month, amount);
	    // then
		Integer findAmount = usages.get(year).get(month);
		Assertions.assertThat(findAmount).isEqualTo(10);

		Assertions.assertThat(result.get("laterAmount")).isEqualTo(55);
		Assertions.assertThat(result.get("change")).isEqualTo(45);
	}
}
