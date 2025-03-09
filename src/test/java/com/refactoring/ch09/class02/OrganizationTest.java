package com.refactoring.ch09.class02;

import com.refactoring.ch09.class02.Organization;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrganizationTest {

	@DisplayName("사용자는 기관의 이름과 나라를 출력한다")
	@Test
	void testToString(){
	    // given
		Organization organization = new Organization("milltory", "korea");
		// when
		String result = organization.toString();
		// then
		Assertions.assertThat(result).isEqualTo("milltory, korea");

	}

}
