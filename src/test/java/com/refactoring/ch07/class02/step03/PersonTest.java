package com.refactoring.ch07.class02.step03;

import com.refactoring.ch07.class02.step03.Course;
import com.refactoring.ch07.class02.step03.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


class PersonTest {
	
	@DisplayName("Person 객체의 코스 리스트를 참조시 복사본을 받는다")
	@Test
	void getCourses(){
	    // given
	    Course course1 = new Course("Introduction to Programming", false);
		Course course2 = new Course("Object Oriented Programming", true);
		Course course3 = new Course("Operating System", true);
		ArrayList<Course> courses = new ArrayList<>(Arrays.asList(course1, course2, course3));
		Person lee = new Person("lee", courses);
	    // when
		List<Course> copyCourse = lee.getCourses();
		// The list itself cannot be modified
		Throwable throwable = catchThrowable(() -> copyCourse.add(new Course("Data Structure", false)));
		// However, you can modify the values of the internal elements of the collection.
		copyCourse.get(0).setName("java");
		// then
		assertThat(throwable).isInstanceOf(UnsupportedOperationException.class);
		assertThat(lee.getCourses().get(0).getName()).isEqualTo("java");
	}

}
