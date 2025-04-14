package com.refactoring.ch11.class05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderStep01Test {

    @Test
    void getFinalPrice() {
        // given
        OrderStep01 order = new OrderStep01(10, 1000);
        // when
        int price = order.getFinalPrice();
        // then
        Assertions.assertThat(price).isEqualTo(9500);

    }
}