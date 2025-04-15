package com.refactoring.ch12.class07.step03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonTest {

	@DisplayName("남자의 명수를 계산한다")
	@Test
	void testMaleCount() {
		// given
		List<Person> people = List.of(Person.createPerson("kim", "M")
				, Person.createPerson("lee", "M"),
				Person.createPerson("park", "F"));
		// when
		long maleCount = people.stream().filter(Person::isMale).count();
		long femaleCount = people.stream().filter(Person::isFemale).count();

		// then
		Assertions.assertThat(maleCount).isEqualTo(2);
		Assertions.assertThat(femaleCount).isEqualTo(1);
	}

	@DisplayName("이름과 성별을 전달하여 객체를 생성한다")
	@Test
	void createPerson() {
		// given
		String name = "kim";
		String gender = "M";
		// when
		Person person = Person.createPerson(name, gender);
		// then
		Assertions.assertThat(person).isInstanceOf(Person.class);
	}
}
