package com.refactoring.ch11.class03.step01;

import java.time.LocalDate;
import java.util.List;

public class Delivery {

	public LocalDate rushDeliveryDate(Order order) {
		int deliveryTime = 0;
		if (List.of("MA", "CT").contains(order.getDeliveryState())){
			deliveryTime += 1;
		}else if (List.of("NY", "NH").contains(order.getDeliveryState())){
			deliveryTime += 2;
		}else{
			deliveryTime += 3;
		}
		return order.getPlacedOn().plusDays(1 + deliveryTime);
	}

	public LocalDate regularDeliveryDate(Order order) {
		int deliveryTime = 0;
		if (List.of("MA", "CT", "NY").contains(order.getDeliveryState())){
			deliveryTime += 2;
		}else if (List.of("ME", "NH").contains(order.getDeliveryState())){
			deliveryTime += 3;
		}else{
			deliveryTime += 4;
		}
		return order.getPlacedOn().plusDays(2 + deliveryTime);
	}
}
