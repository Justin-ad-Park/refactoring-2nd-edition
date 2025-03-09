package com.refactoring.ch08.class01.step02;

import com.refactoring.ch08.class01.step02.Account;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountTest {


	@DisplayName("사용자는 계좌의 은행 이자를 계산한다")
	@Test
	void bankCharge(){
	    // given
		Account account = new Account(10, Account.AccountType.PREMIUM);
		// when
		double charge = account.bankCharge();
		// then
		Assertions.assertThat(charge).isCloseTo(17.05, Offset.offset(0.1));

	}
}
