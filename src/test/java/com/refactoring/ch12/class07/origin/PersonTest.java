package com.refactoring.ch12.class07.origin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonTest {

    @DisplayName("남성/여성의 인원수를 계산한다")
    @Test
    void testMaleCount() {
        // given
        List<Person> people = List.of(new Male("kim"), new Male("lee"),
                new Female("park"));
        // when
        long maleCount = people.stream().filter(p -> p instanceof Male).count();
        long femaleCount = people.stream().filter(p -> p instanceof Female).count();

        // then
        Assertions.assertThat(maleCount).isEqualTo(2);
        Assertions.assertThat(femaleCount).isEqualTo(1);
    }

}
