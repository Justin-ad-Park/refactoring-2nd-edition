package com.refactoring.ch07.class05.step01;

import com.refactoring.ch07.class05.step01.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

	@DisplayName("사람의 오피스 전화번호를 출력한다")
	@Test
	void telephoneNumber(){
	    // given
		Person kim = new Person("kim", "042", "12345678");
		// when
		String telephoneNumber = kim.telephoneNumber();
	    // then
		Assertions.assertThat(telephoneNumber).isEqualTo("(042) 12345678");
	}

}
