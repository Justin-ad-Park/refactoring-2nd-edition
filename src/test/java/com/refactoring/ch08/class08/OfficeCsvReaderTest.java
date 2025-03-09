package com.refactoring.ch08.class08;

import com.refactoring.ch08.class08.Office;
import com.refactoring.ch08.class08.OfficeCsvReader;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

class OfficeCsvReaderTest {

	@DisplayName("csv 파일을 읽어서 인디아에 위치한 오피스의 정보를 조회한다")
	@Test
	void readOffices() throws IOException {
	    // given
		OfficeCsvReader reader = new OfficeCsvReader();
		ClassPathResource resource = new ClassPathResource("offices.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String input = br.lines()
			.collect(Collectors.joining("\n"));
		// when
		List<Office> offices = reader.readOffices(input);
		// then
		Assertions.assertThat(offices)
			.hasSize(2)
			.extracting(Office::getName, Office::getCountry, Office::getTelephone)
			.containsExactly(Tuple.tuple("Bangalore", "India", "+91 80 4064 9570"), Tuple.tuple("Chennai", "India", "+91 44 660 44766"));
	}

}
