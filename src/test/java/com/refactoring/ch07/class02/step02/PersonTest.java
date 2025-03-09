package com.refactoring.ch07.class02.step02;


import com.refactoring.ch07.class02.step02.Course;
import com.refactoring.ch07.class02.step02.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


class PersonTest {

	@DisplayName("사용자는 코스를 추가한다")
	@Test
	void addCourse(){
	    // given
		Course course1 = new Course("Introduction to Programming", false);
		Course course2 = new Course("Object Oriented Programming", true);
		Course course3 = new Course("Operating System", true);
		ArrayList<Course> courses = new ArrayList<>(Arrays.asList(course1, course2, course3));
		Person lee = new Person("lee", courses);
	    // when
		lee.addCourse(new Course("java", false));
	    // then
		Assertions.assertThat(lee.numberOfCourses()).isEqualTo(4);
	}

	@DisplayName("사용자는 코스를 삭제한다")
	@Test
	void removeCourse(){
	    // given
		Course course1 = new Course("Introduction to Programming", false);
		Course course2 = new Course("Object Oriented Programming", true);
		Course course3 = new Course("Operating System", true);
		ArrayList<Course> courses = new ArrayList<>(Arrays.asList(course1, course2, course3));
		Person lee = new Person("lee", courses);
	    // when
		lee.removeCourse(new Course("Operating System", true));
	    // then
		Assertions.assertThat(lee.numberOfCourses()).isEqualTo(2);
	}
}
