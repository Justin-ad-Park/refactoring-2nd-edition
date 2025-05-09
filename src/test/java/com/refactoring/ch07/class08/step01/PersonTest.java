package com.refactoring.ch07.class08.step01;


import com.refactoring.ch07.class08.step01.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PersonTest {

	@DisplayName("사용자는 kim의 매니저 이름을 출력한다")
	@Test
	void manager(){
		// given
		Person kim = new Person("kim", "HR001", "Alice");
		// when
		String manager = kim.getDepartment().getManager();
		// then
		Assertions.assertThat(manager).isEqualTo("Alice");
	}

}
