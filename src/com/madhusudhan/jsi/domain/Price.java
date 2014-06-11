package com.madhusudhan.jsi.domain;

public class Price {

	private String instrument="";
	private double price = 0.0;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	@Override
	public String toString() {
		return "Price [instrument=" + instrument + ", price=" + price + "]";
	}
}
