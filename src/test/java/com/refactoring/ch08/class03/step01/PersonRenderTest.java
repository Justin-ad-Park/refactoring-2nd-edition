package com.refactoring.ch08.class03.step01;

import com.refactoring.ch08.class03.step01.Person;
import com.refactoring.ch08.class03.step01.PersonRender;
import com.refactoring.ch08.class03.step01.Photo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonRenderTest {

	@DisplayName("사용자가 가지고 있는 포토를 출력한다")
	@Test
	void renderPerson(){
	    // given
		PersonRender personRender = new PersonRender();
		// when
		String result = personRender.renderPerson(new Person("kim", new Photo("title1", "location", "url", LocalDate.of(2024, 8, 16))));
		// then
		Assertions.assertThat(result).isEqualTo("<p>Person: kim</p>\n"
			+ "<div>\n"
			+ "  <img src=\"url\"/>\n"
			+ "</div>\n"
			+ "<p>제목: title1</p>\n"
			+ "<p>위치: location</p>\n"
			+ "<p>날짜: 2024-08-16</p>\n");
	}

	@DisplayName("photoDiv 테스트")
	@Test
	void photoDiv(){
	    // given
		PersonRender personRender = new PersonRender();
		// when
		String result = personRender.photoDiv(new Photo("title1", "location", "url", LocalDate.of(2024, 8, 16)));
		// then
		Assertions.assertThat(result).isEqualTo("<div>\n"
			+ "<p>제목: title1</p>\n"
			+ "<p>위치: location</p>\n"
			+ "<p>날짜: 2024-08-16</p>\n"
			+ "</div>");
	}
}
