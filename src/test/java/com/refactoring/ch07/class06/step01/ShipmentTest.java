package com.refactoring.ch07.class06.step01;

import com.refactoring.ch07.class06.step01.Shipment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShipmentTest {

	@DisplayName("사용자는 추적 정보를 출력한다")
	@Test
	void trackingInfo(){
	    // given
		Shipment cj = new Shipment("CJ 대한통운", "123456");
		// when
		String trackingInfo = cj.trackingInfo();
		// then
		Assertions.assertThat(trackingInfo).isEqualTo("CJ 대한통운: 123456");
	}

	@DisplayName("사용자는 운송회사를 변경한다")
	@Test
	void setShippingCompany(){
	    // given
		Shipment cj = new Shipment("CJ 대한통운", "123456");
	    // when
	    cj.setShippingCompany("우체국");
	    // then
		Assertions.assertThat(cj.getShippingCompany()).isEqualTo("우체국");
	}

}
