package com.refactoring.ch12.class10.step01;

import com.refactoring.ch12.class10.step01.Booking;
import com.refactoring.ch12.class10.step01.Extra;
import com.refactoring.ch12.class10.step01.Show;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class BookingTest {

	// 성수기는 7월 1일 ~ 8월 1일이다
	@DisplayName("성수기가 아닌 일반 예약은 예약 옵션에 토크백이 있으면 할 수 있다")
	@Test
	void hasTalkback() {
		// given
		Show show = new Show(10000, List.of("talkback"));
		LocalDate date = LocalDate.of(2024, 6, 30);
		Booking booking = new Booking(show, date);
		// when
		boolean result = booking.hasTalkback();
		// then
		Assertions.assertThat(result).isTrue();
	}

	@DisplayName("프리미엄 관객은 성수기 관계없이 토크백이 있으면 시간을 가질수 있다")
	@Test
	void hasTalkbackForPremium() {
		// given
		Show show = new Show(10000, List.of("talkback"));
		LocalDate date = LocalDate.of(2024, 6, 30);
		Booking booking = Booking.createPremiumBooking(show, date, new ArrayList<>());
		// when
		boolean result = booking.hasTalkback();
		// then
		Assertions.assertThat(result).isTrue();
	}

	@DisplayName("성수기의 일반 예약은 기본 가격의 15% 더 받는다")
	@Test
	void testBasePriceForNormalBooking() {
		// given
		Show show = new Show(10000, List.of("talkback"));
		LocalDate date = LocalDate.of(2024, 7, 1);
		Booking booking = new Booking(show, date);
		// when
		int basePrice = booking.calculateBasePrice();
		// then
		Assertions.assertThat(basePrice).isEqualTo(11500);
	}

	@DisplayName("성수기의 프리미엄 예약은 별도의 프리미엄 요금을 더하여 받는다")
	@Test
	void testBasePriceForPremiumBooking() {
		// given
		Show show = new Show(10000, List.of("talkback"));
		LocalDate date = LocalDate.of(2024, 7, 1);
		Extra premiumFee = new Extra("premiumFee", 3000);
		Booking booking = Booking.createPremiumBooking(show, date, List.of(premiumFee));
		// when
		int basePrice = booking.calculateBasePrice();
		// then
		Assertions.assertThat(basePrice).isEqualTo(14500);
	}

	@DisplayName("성수기가 아닌 프리미어 에약에 디너 옵션이 있으면 식사할 수 있다")
	@Test
	void testHasDinnerForPremiumBooking() {
		// given
		Show show = new Show(10000, List.of("talkback"));
		LocalDate date = LocalDate.of(2024, 6, 30);
		Extra premiumFee = new Extra("premiumFee", 3000);
		Extra dinner = new Extra("dinner", 5000);

		Booking booking = Booking.createPremiumBooking(show, date, List.of(premiumFee, dinner));
		// when
		boolean result = booking.hasDinner();
		// then
		Assertions.assertThat(result).isTrue();
	}

	@DisplayName("정적 팩토리를 이용하여 객체를 생성한다")
	@Test
	void testCreateBooking() {
		// given
		Show show = new Show(10000, List.of("talkback"));
		LocalDate date = LocalDate.of(2024, 6, 30);
		Extra premiumFee = new Extra("premiumFee", 3000);
		Extra dinner = new Extra("dinner", 5000);
		// when
		Booking booking = Booking.createBooking(show, date);
		Booking premiumBooking = Booking.createPremiumBooking(show, date, List.of(premiumFee, dinner));
		// then
		Assertions.assertThat(booking.calculateBasePrice()).isEqualTo(10000);
		Assertions.assertThat(premiumBooking.calculateBasePrice()).isEqualTo(18000);
	}
}
