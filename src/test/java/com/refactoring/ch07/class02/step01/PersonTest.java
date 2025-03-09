package com.refactoring.ch07.class02.step01;

import com.refactoring.ch07.class02.step01.Course;
import com.refactoring.ch07.class02.step01.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonTest {
	@DisplayName("사용자는 Person 객체가 가지고 있는 코스들의 개수를 카운팅한다")
	@Test
	void numberOfCouses(){
	    // given
		Course course1 = new Course("Introduction to Programming", false);
		Course course2 = new Course("Object Oriented Programming", true);
		Course course3 = new Course("Operating System", true);
		Person lee = new Person("lee", List.of(course1, course2, course3));
		// when
		long numAdvancedCourses = lee.getCourses().stream()
			.filter(Course::isAdvanced)
			.count();
		// then
		Assertions.assertThat(numAdvancedCourses).isEqualTo(2);
	}

	// problem : If you set up the entire courese collection using setter, the client can modify this collection as he pleases.
	@DisplayName("setCourse 메서드를 이용하여 코스 컬렉션 통째로 교체한다")
	@Test
	void setCourse(){
		// given
		Course course1 = new Course("Introduction to Programming", false);
		Course course2 = new Course("Object Oriented Programming", true);
		Course course3 = new Course("Operating System", true);
		Person lee = new Person("lee", List.of(course1, course2, course3));
		// when
		lee.setCourses(List.of(new Course("java", false)));
		// then
		Assertions.assertThat(lee.getCourses().size()).isEqualTo(1);
	}
}
