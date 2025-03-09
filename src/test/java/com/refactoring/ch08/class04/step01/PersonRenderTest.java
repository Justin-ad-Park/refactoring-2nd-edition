package com.refactoring.ch08.class04.step01;

import com.refactoring.ch08.class04.step01.Person;
import com.refactoring.ch08.class04.step01.PersonRender;
import com.refactoring.ch08.class04.step01.Photo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

class PersonRenderTest {

	@DisplayName("최신 포토 리스트들의 HTML 태그를 반환한다")
	@Test
	void listRecentPhotos() {
		// given
		PersonRender personRender = new PersonRender();
		LocalDate now = LocalDate.now();
		// when
		String result = personRender.listRecentPhotos(
			List.of(new Photo("title1", "seoul", "url", now)));
		// then
		String date = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
		Assertions.assertThat(result).isEqualTo("<div>\n"
			+ "<p>제목: title1</p>\n"
			+ "<p>날짜: " + date + "</p>\n"
			+ "<p>위치: seoul</p>\n"
			+ "</div>");
	}

	@DisplayName("사용자가 가지고 있는 포토를 출력한다")
	@Test
	void renderPerson() {
		// given
		PersonRender personRender = new PersonRender();
		// when
		String result = personRender.renderPerson(
			new Person("kim", new Photo("title1", "location", "url", LocalDate.of(2024, 8, 16))));
		// then
		Assertions.assertThat(result).isEqualTo("<p>Person: kim</p>\n"
			+ "<div>\n"
			+ "  <img src=\"url\"/>\n"
			+ "</div>\n"
			+ "<p>제목: title1</p>\n"
			+ "<p>날짜: 2024-08-16</p>\n"
			+ "<p>위치: location</p>\n");
	}

}
