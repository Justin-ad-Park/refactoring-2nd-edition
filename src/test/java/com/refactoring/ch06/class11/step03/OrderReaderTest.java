package com.refactoring.ch06.class11.step03;

import com.refactoring.ch06.class11.step02.OrderReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class OrderReaderTest {
	@DisplayName("json 파일을 읽어서 ready 상태인 주문의 개수를 센다")
	@Test
	void countOrders() throws IOException {
		// given
		com.refactoring.ch06.class11.step02.OrderReader orderReader = new OrderReader();
		// when
		long count = orderReader.run(new String[] {"-r", "orders.json"});
		// then
		Assertions.assertThat(count).isEqualTo(2L);
	}
}
