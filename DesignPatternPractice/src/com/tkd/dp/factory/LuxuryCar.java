package com.tkd.dp.factory;

public class LuxuryCar extends Car {

	public LuxuryCar() {
		super(CarType.LUXURY);
	}

	@Override
	protected void construct() {
		System.out.println("Building Luxury Car");

	}

}
