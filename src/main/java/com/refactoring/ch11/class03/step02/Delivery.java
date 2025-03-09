package com.refactoring.ch11.class03.step02;

import java.time.LocalDate;

public class Delivery {

	public LocalDate rushDeliveryDate(Order order){
		return deliveryDate(order, true);
	}

	public LocalDate regularDeliveryDate(Order order){
		return deliveryDate(order, false);
	}

	private LocalDate deliveryDate(Order order, boolean isRush){
		LocalDate result;
		int deliveryTime;
		if (order.getDeliveryState().equals("MA") || order.getDeliveryState().equals("CT")) {
			deliveryTime = isRush ? 1 : 2;
		}else if (order.getDeliveryState().equals("NY") || order.getDeliveryState().equals("NH")) {
			deliveryTime = 2;
			if (order.getDeliveryState().equals("NH") && !isRush){
				deliveryTime = 3;
			}
		}else if (isRush){
			deliveryTime = 3;
		}else if (order.getDeliveryState().equals("ME")){
			deliveryTime = 3;
		}else{
			deliveryTime = 4;
		}
		result = order.getPlacedOn().plusDays(deliveryTime + 2);
		if (isRush){
			result = result.minusDays(1);
		}
		return result;
	}
}
