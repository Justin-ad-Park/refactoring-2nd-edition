package com.refactoring.ch09.class04;

import com.refactoring.ch09.class04.Person;
import com.refactoring.ch09.class04.TeleponeNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

	@DisplayName("OfficeAreaCode를 MA로 수정한다")
	@Test
	void setOfficeAreaCode(){
	    // given
		Person person = new Person("US", "1234");
		// when
	    person.setOfficeAreaCode("MA");
	    // then
		Assertions.assertThat(person.getOfficeAreaCode()).isEqualTo("MA");
	}

	@DisplayName("오피스 번호를 4567로 수정한다")
	@Test
	void setOfficeNumber(){
		// given
		Person person = new Person("US", "1234");
		// when
		person.setOfficeNumber("4567");
		// then
		Assertions.assertThat(person.getOfficeNumber()).isEqualTo("4567");
	}

	@DisplayName("TelephoneNumber 객체의 동치성을 테스트한다")
	@Test
	void testEquality(){
	    // given
		TeleponeNumber a = new TeleponeNumber("US", "1234");
		TeleponeNumber b = new TeleponeNumber("US", "1234");
		// when
		boolean result = a.equals(b);
		// then
		Assertions.assertThat(result).isTrue();
	}
}
