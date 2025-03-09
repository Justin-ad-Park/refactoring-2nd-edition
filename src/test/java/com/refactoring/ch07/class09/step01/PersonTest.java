package com.refactoring.ch07.class09.step01;

import com.refactoring.ch07.class09.step01.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonTest {

	@DisplayName("사람들중에서 이름이 'Don'인 사람이 있는지 조회한다")
	@Test
	void foundPerson(){
	    // given
		List<Person> personList = List.of(new Person("Don"), new Person("John"), new Person("Jane"));
		// when
		String result = Person.foundPerson(personList);
		// then
		Assertions.assertThat(result).isEqualTo("Don");
	}

}
