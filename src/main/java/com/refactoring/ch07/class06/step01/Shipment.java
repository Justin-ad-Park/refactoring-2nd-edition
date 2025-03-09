package com.refactoring.ch07.class06.step01;

public class Shipment {
	private String shippingCompany;
	private String trackingNumber;

	public Shipment(String shippingCompany, String trackingNumber) {
		this.shippingCompany = shippingCompany;
		this.trackingNumber = trackingNumber;
	}

	public String trackingInfo(){
		return shippingCompany + ": " + trackingNumber;
	}

	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	public String getShippingCompany() {
		return this.shippingCompany;
	}
}
