package com.refactoring.ch12.class07.step03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class Person02Test {

    @DisplayName("남자의 명수를 계산한다")
    @Test
    void testMaleCount() {
        // given
        List<Person02> people = List.of(Person02.createPerson("kim", "M")
                , Person02.createPerson("lee", "M"),
                Person02.createPerson("park", "F"));
        // when
        long maleCount = people.stream().filter(p -> p.isGender("M")).count();
        long femaleCount = people.stream().filter(p -> p.isGender("F")).count();

        // then
        Assertions.assertThat(maleCount).isEqualTo(2);
        Assertions.assertThat(femaleCount).isEqualTo(1);
    }

    @DisplayName("이름과 성별을 전달하여 객체를 생성한다")
    @Test
    void createPerson02() {
        // given
        String name = "kim";
        String gender = "M";
        // when
        Person02 person02 = Person02.createPerson(name, gender);
        // then
        Assertions.assertThat(person02).isInstanceOf(Person02.class);
    }
}