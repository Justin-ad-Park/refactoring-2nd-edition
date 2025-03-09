package com.refactoring.ch06.class01;

import java.time.LocalDate;

public interface LocalDateFactory {

	default LocalDate now(){
		return LocalDate.now();
	}
}
