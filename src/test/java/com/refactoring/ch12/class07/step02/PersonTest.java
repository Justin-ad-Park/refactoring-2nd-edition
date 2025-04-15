package com.refactoring.ch12.class07.step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class PersonTest {

    @DisplayName("남성/여성의 인원수를 계산한다")
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

}